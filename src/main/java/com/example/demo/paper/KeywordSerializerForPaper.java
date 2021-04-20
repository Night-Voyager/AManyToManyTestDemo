package com.example.demo.paper;

import com.example.demo.keyword.Keyword;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class KeywordSerializerForPaper extends JsonSerializer<Set<Keyword>> {
    @Override
    public void serialize(Set<Keyword> keywords, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
//        String [] keywordStringArray = new String[keywords.size()];
//        Iterator<Keyword> keywordIterator = keywords.iterator();
//        for (int i = 0; i < keywords.size(); i++) {
//            keywordStringArray[i] = keywordIterator.next().getKeyword();
//        }
//        jsonGenerator.writeArray(keywordStringArray, 0, keywords.size());

        jsonGenerator.writeStartArray();
        for (Keyword keyword: keywords) {
            jsonGenerator.writeString(keyword.getKeyword());
        }
        jsonGenerator.writeEndArray();

//        jsonGenerator.writeString("");
    }
}
