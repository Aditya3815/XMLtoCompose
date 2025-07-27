package com.example.xmltocompose.di

import com.example.xmltocompose.repository.CourseRepository
import com.example.xmltocompose.repository.FakeCourseRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    abstract fun bindCourseRepository(
        fakeCourseRepository: FakeCourseRepository
    ): CourseRepository
}
