package me.tandeneck.tanutils.bean

import timber.log.Timber
import javax.inject.Inject

/**
 * @Author:         tdn
 * @Time            2020/12/22
 * @Description:
 */
class TruckBean @Inject constructor(private val driverBean: DriverBean) {

    @BindGasEngine
    @Inject
    lateinit var gasEngine: IEngine

    @BindElectricEngine
    @Inject
    lateinit var electricEngine: IEngine

    fun deliver() {
        gasEngine.start()
        electricEngine.start()
        Timber.i("Truck is delivering cargo.Driven by $driverBean")
        gasEngine.shutdown()
        electricEngine.shutdown()
    }
}