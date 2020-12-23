package me.tandeneck.tanutils.bean

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import me.tandeneck.tanutils.MyApplication

/**
 * @Author:         tdn
 * @Time            2020/12/22
 * @Description:
 */
@Module
@InstallIn(ApplicationComponent::class)
class ApplicationModule {
    @Provides
    fun provideMyApplication(application: Application): MyApplication {
        return application as MyApplication
    }

}