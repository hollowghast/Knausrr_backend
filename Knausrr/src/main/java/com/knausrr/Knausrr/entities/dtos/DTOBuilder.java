package com.knausrr.Knausrr.entities.dtos;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class DTOBuilder <T>{
    private final Supplier<T> supplier;

    public DTOBuilder(Supplier<T> supplier) {
        this.supplier = supplier;
    }

    public static <T> DTOBuilder<T> of(Supplier<T> supplier){
        return new DTOBuilder<>(supplier);
    }

    public <P> DTOBuilder<T> with(BiConsumer<T, P> consumer, P value){
        return new DTOBuilder<>(() -> {
           T object = supplier.get();
           consumer.accept(object, value);
           return object;
        });
    }

    public <P> DTOBuilder<T> without(BiConsumer<T, P> consumer){
        return new DTOBuilder<>(() -> {
            T object = supplier.get();
            consumer.accept(object, null);
            return object;
        });
    }

    public T build(){
        return supplier.get();
    }
}
