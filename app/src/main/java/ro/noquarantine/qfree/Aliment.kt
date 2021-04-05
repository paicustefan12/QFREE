package ro.noquarantine.qfree

class Aliment(private var Name: String? = "", private var grams: Float = 0F) {

    fun getName(): String? {
        return Name
    }

    fun getGrams(): Float {
        return grams
    }

    fun setName(Name: String) {
        this.Name = Name
    }

    fun setGrams(grams: Float) {
        this.grams = grams
    }

}