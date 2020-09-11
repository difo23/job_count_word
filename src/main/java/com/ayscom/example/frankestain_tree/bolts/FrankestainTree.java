package com.ayscom.example.frankestain_tree.bolts;

import java.text.BreakIterator;
import java.util.Map;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.BasicOutputCollector;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseBasicBolt;
import backtype.storm.topology.base.BaseRichBolt;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;
import org.bson.Document;

//There are a variety of bolt types. In this case, we use BaseBasicBolt
public class FrankestainTree extends BaseRichBolt {
    private OutputCollector collector;
  //Execute is called to process tuples
  @Override
  public void execute(Tuple tuple) {
    //Get the sentence content from the tuple

   // String sentence = tuple.getString(0);
    String xdrs = tuple.toString();
   // String fields= tuple;
    //An iterator to get each word
   // BreakIterator boundary=BreakIterator.getWordInstance();
    //Give the iterator the sentence
   // boundary.setText(sentence);
    //Find the beginning first word
    //int start=boundary.first();
    //Iterate over each word and emit it to the output stream
    //for (int end=boundary.next(); end != BreakIterator.DONE; start=end, end=boundary.next()) {
      //get the word
      //String word=sentence.substring(start,end);
      //If a word is whitespace characters, replace it with empty
      //word=word.replaceAll("\\s+","");
      //if it's an actual word, emit it
      //if (!word.equals("")) {
       this.collector.emit(tuple, new Values(xdrs));
           if(false){
                    //this.collector.ack(tuple);
               }else{
               // this.collector.fail(tuple);
               }

     // }
    //}
  }

  //Declare that emitted tuples will contain a word field
  @Override
  public void declareOutputFields(OutputFieldsDeclarer declarer) {
    declarer.declare(new Fields("xdrs"));
  }

    @Override
    public void prepare(Map map, TopologyContext topologyContext, OutputCollector outputCollector) {
        this.collector = outputCollector;
    }


   // public void execute(Tuple tuple) {

   // }
}