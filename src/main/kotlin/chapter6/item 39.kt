package chapter6



class ValueMatcher<T> private constructor(
    private val value: T? = null,
    private val matcher: Matcher
){
    fun match(value : T?) = when(matcher){
        Matcher.EQAUL -> value == this.value
        Matcher.NOT_EQUAL -> value != this.value
        Matcher.LIST_EMPTY -> value is List<*> && value.isEmpty()
    }

    enum class Matcher {
        EQAUL,
        NOT_EQUAL,
        LIST_EMPTY
    }


    fun <T> equal(value: T) =ValueMatcher<T>(value, Matcher.EQAUL)
    fun <T> notEqual(value: T) =ValueMatcher<T>(value, Matcher.NOT_EQUAL)

}

// sealed class 버전으로 만들면?


sealed class SealedValueMatcher<T>{
    abstract fun match(value: T): Boolean

    class Eqaul<T>(val value: T) : SealedValueMatcher<T>(){
        override fun match(value: T): Boolean  = value ==this.value
    }

    class NotEqaul<T>(val value: T) : SealedValueMatcher<T>(){
        override fun match(value: T): Boolean  = value !=this.value
    }
}

// abstract class 버전은?

abstract class AbstractValueMatcher<T> {
    abstract fun match(value: T): Boolean
}

//class Eqaul<T> : AbstractValueMatcher<T>() {
//    override fun match(value: T): Boolean {
//
//    }
//}




