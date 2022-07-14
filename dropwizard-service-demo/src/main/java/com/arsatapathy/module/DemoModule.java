package com.arsatapathy.module;

import com.arsatapathy.repo.StudentRepo;
import com.arsatapathy.repo.StudentStub;
import com.google.inject.AbstractModule;

public class DemoModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(StudentRepo.class).to(StudentStub.class);
    }
}
