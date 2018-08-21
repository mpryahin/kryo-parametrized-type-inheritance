package io.cleverdata.dmpkit;

import java.io.ByteArrayOutputStream;
import java.util.Arrays;
import java.util.List;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Output;

public class BaseType<R> {

    static class CollectionType extends BaseType<Boolean> {

        private final List<BaseType<?>> children;

        CollectionType(BaseType<?>... child) {
            this.children = Arrays.asList(child);
        }
    }

    static class ValueType<R> extends BaseType<R> {

        private final R v;

        ValueType(R v) {
            this.v = v;
        }
    }

    public static void main(String[] args) {
        try (Output output = new Output(new ByteArrayOutputStream())) {
            CollectionType value = new CollectionType(new ValueType<>("hello"));
            new Kryo().writeClassAndObject(output, value);
        }
    }
}
