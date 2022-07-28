/*

Copy right here
 */
package com.vj.baseproject.util.extension

/**
 * Apply same action on batch objects
 */
fun <T> applyAction(vararg anys: T, onAction: (any: T) -> Unit) {
    for (i in anys) {
        onAction(i)
    }
}

/**
 * Apply same action on batch objects which is arraylist
 */
fun <T> applyArrayAction(anys: ArrayList<T>, onAction: (any: T) -> Unit) {
    for (i in anys) {
        onAction(i)
    }
}
