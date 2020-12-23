package me.tandeneck.tanutils.bean

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Qualifier

/**
 * @Author:         tdn
 * @Time            2020/12/22
 * @Description:
 */
interface IEngine {
    fun start()
    fun shutdown()
}


@Module
@InstallIn(ActivityComponent::class)
abstract class EngineModule {

    @BindGasEngine
    @Binds
    abstract fun bindGasEngine(gasEngine: GasEngine): IEngine

    @BindElectricEngine
    @Binds
    abstract fun bindElectricEngine(electricEngine: ElectricEngine): IEngine
}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class BindGasEngine

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class BindElectricEngine


class GasEngine @Inject constructor() : IEngine {
    override fun start() {
        Timber.i("Gas engine start.")
    }


    override fun shutdown() {
        Timber.i("Gas engine shutdown.")
    }

}

class ElectricEngine @Inject constructor() : IEngine {
    override fun start() {
        Timber.i("Electric engine start.")
    }

    override fun shutdown() {
        Timber.i("Electric engine shutdown.")
    }

}
