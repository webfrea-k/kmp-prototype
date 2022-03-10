import platform.Foundation.NSUserDefaults
import platform.Foundation.setValue

actual fun platformName(): String = "iOS"

actual var persistentString: String
    get() = NSUserDefaults.standardUserDefaults.stringForKey("some_persistent_string") ?: ""
    set(value) = NSUserDefaults.standardUserDefaults.setValue(value, "some_persistent_string")