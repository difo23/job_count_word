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
/**
 * Created by lramirez on 12/06/15.
 */

public class FrankestainSetInterval extends BaseRichBolt {

    private OutputCollector collector;
    @Override
    public void execute(Tuple tuple) {
        //Get the sentence content from the tuple
        //String sentence = tuple.getStringByField("xdrs");
        String sentence = tuple.toString();
        //String doc= (String) tuple.getValue(4);
        //String[] array = sentence.split(",");

       // sentence.split('\]'):
        //An iterator to get each word
        //BreakIterator boundary=BreakIterator.getWordInstance();
        //Give the iterator the sentence
        /*boundary.setText(sentence);
        //Find the beginning first word
        int start=boundary.first();
        //Iterate over each word and emit it to the output stream
        for (int end=boundary.next(); end != BreakIterator.DONE; start=end, end=boundary.next()) {
            //get the word
            String word=sentence.substring(start,end);
            //If a word is whitespace characters, replace it with empty
            word=word.replaceAll("\\s+","");
            //if it's an actual word, emit it
            if (!word.equals("")) {
                collector.emit(new Values(word));
            }
        }*/

      // for(int i= 0; array.length-1>i;i++) {
        //    collector.emit(new Values(array[i]));
        //}
        this.collector.emit(new Values(sentence));
        if(false){
            this.collector.ack(tuple);
        }else{
            //this.collector.fail(tuple);
        }

    }

    //Declare that emitted tuples will contain a word field
    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declare(new Fields("word"));
    }

    @Override
    public void prepare(Map map, TopologyContext topologyContext, OutputCollector outputCollector) {

        this.collector = outputCollector;
    }


}
