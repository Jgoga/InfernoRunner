package com.github.srad.infernorunner.entity

import com.badlogic.gdx.math.Vector3
import com.badlogic.gdx.physics.bullet.collision.btBoxShape
import com.github.srad.infernorunner.core.CollisionMasks
import com.github.srad.infernorunner.core.Resource
import com.github.srad.infernorunner.entity.player.PlayerInstance

class FountainInstance : PhysicalModelInstance(Resource.fountainModel, PhysicalAttributes(btBoxShape(Vector3(2.5f, 0.8f, 2.5f)), 1f, CollisionMasks(PlayerInstance::class, PhysicalBlockInstance::class))) {
    override val name = "Fountain"
    private val controllers = AnimationControllers()

    override fun transformModel() {
        transform.setTranslation(rigidBody.worldTransform.getTranslation(Vector3.Zero))
    }

    init {
        transform.scl(0.03f)
        controllers.addAnimation("Fountain.001|Fountain.001Action", this, 0.1f)
        controllers.addAnimation("Fountain.002|Fountain.001Action", this, 0.1f)
        controllers.addAnimation("Fountain.003|Fountain.001Action", this, 0.1f)
        controllers.addAnimation("Fountain.004|Fountain.001Action", this, 0.1f)
        controllers.addAnimation("Fountain.005|Fountain.001Action", this, 0.1f)
        //println(model.animations.joinToString { it.id })
    }

    override fun update(delta: Float) {
        controllers.update(delta)
    }
}