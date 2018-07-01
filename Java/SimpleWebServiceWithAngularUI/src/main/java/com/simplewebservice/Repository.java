package com.simplewebservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class Repository implements CarRepository {

    private List<Car> cars;

    public Repository() {
        cars = new ArrayList<>();
    }

    @Override
    public List<Car> findAll() {
        return this.cars;
    }

    @Override
    public List<Car> findAll(Sort sort) {
        return null;
    }

    @Override
    public List<Car> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public <S extends Car> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Car> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Car> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Car getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends Car> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Car> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public Page<Car> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Car> S save(S s) {
        this.cars.add(s);
        return null;
    }

    @Override
    public Optional<Car> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Car car) {

    }

    @Override
    public void deleteAll(Iterable<? extends Car> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Car> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Car> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Car> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Car> boolean exists(Example<S> example) {
        return false;
    }
}
