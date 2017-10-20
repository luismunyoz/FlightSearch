package com.luismunyoz.flightsearch.di

import android.content.Context
import com.birbit.android.jobqueue.JobManager
import com.luismunyoz.flightsearch.App
import com.luismunyoz.flightsearch.domain.BusImpl
import com.luismunyoz.flightsearch.domain.interactor.base.Bus
import com.luismunyoz.flightsearch.domain.interactor.base.CustomJobManager
import com.luismunyoz.flightsearch.domain.interactor.base.InteractorExecutor
import com.luismunyoz.flightsearch.domain.interactor.base.InteractorExecutorImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val app: App) {

    @Provides @Singleton
    fun provideApplication(): App = app

    @Provides @Singleton @ApplicationQualifier
    fun provideApplicationContext(): Context = app

    @Provides @Singleton
    fun provideBus(): Bus = BusImpl()

    @Provides @Singleton
    fun provideJobManager(@ApplicationQualifier context: Context): JobManager = CustomJobManager(context)

    @Provides @Singleton
    fun provideInteractorExecutor(jobManager: JobManager, bus: Bus): InteractorExecutor = InteractorExecutorImpl(jobManager, bus)

}