// !DIAGNOSTICS: -UNUSED_PARAMETER -PARAMETER_NAME_CHANGED_ON_OVERRIDE
// !WITH_NEW_INFERENCE
// FULL_JDK

class KotlinMap1<K, V> : java.util.AbstractMap<K, V>() {
    override val entries: MutableSet<MutableMap.MutableEntry<K, V>>
        get() = throw UnsupportedOperationException()

    override fun remove(x: K, y: V) = true
}

class KotlinMap2 : java.util.AbstractMap<String, Int>() {
    override val entries: MutableSet<MutableMap.MutableEntry<String, Int>>
        get() = throw UnsupportedOperationException()

    override fun remove(x: String, y: Int) = true
}

fun foo(x: MutableMap<String, Int>, y: java.util.HashMap<String, Int>, z: java.util.AbstractMap<String, Int>) {
    x.remove("", 1)
    x.<!INAPPLICABLE_CANDIDATE!>remove<!>("", "")
    x.<!INAPPLICABLE_CANDIDATE!>remove<!>("", null)

    y.remove("", 1)
    y.<!INAPPLICABLE_CANDIDATE!>remove<!>("", "")
    y.remove("", null)

    z.remove("", 1)
    z.<!INAPPLICABLE_CANDIDATE!>remove<!>("", "")
    z.remove("", null)
}
