import com.example.kmmprototype.android.Global

actual fun platformName(): String = "Android"

actual var persistentString: String
    get() = Global.prefs?.getString("some_persistent_string", null) ?: ""
    set(value) = Global.prefs?.edit()?.putString("some_persistent_string", value)?.apply() as Unit