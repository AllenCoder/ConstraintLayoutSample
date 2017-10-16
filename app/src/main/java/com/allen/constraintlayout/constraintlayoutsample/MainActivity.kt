package com.allen.constraintlayout.constraintlayoutsample

import android.animation.ValueAnimator
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.animation.LinearInterpolator
import java.util.concurrent.TimeUnit


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val earthImage = findViewById(R.id.earth_image)
        val marsImage = findViewById(R.id.mars_image)
        val saturnImage = findViewById(R.id.saturn_image)

        val earthAnimator = animatePlanet(earthImage, TimeUnit.SECONDS.toMillis(2))
        val marsAnimator = animatePlanet(marsImage, TimeUnit.SECONDS.toMillis(6))
        val saturnAnimator = animatePlanet(saturnImage, TimeUnit.SECONDS.toMillis(12))

        earthAnimator.start()
        marsAnimator.start()
        saturnAnimator.start()
    }

    private fun animatePlanet(planet: View, orbitDuration: Long): ValueAnimator {
        val anim = ValueAnimator.ofFloat(0.0f, 359.0f)
        anim.addUpdateListener { valueAnimator ->
            val value= valueAnimator.animatedValue as Float
            val layoutParams = planet.getLayoutParams() as ConstraintLayout.LayoutParams
            layoutParams.circleAngle = value
            planet.setLayoutParams(layoutParams)
        }
        anim.duration = orbitDuration
        anim.interpolator = LinearInterpolator()
        anim.repeatMode = ValueAnimator.RESTART
        anim.repeatCount = ValueAnimator.INFINITE

        return anim
    }

}
