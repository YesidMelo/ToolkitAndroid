package com.mitiempo.toolkitandroidclases.Utilidades.Permisos

import android.Manifest
import android.annotation.SuppressLint

/**
 * Direccion de la lista de permisos
 * https://developer.android.com/reference/kotlin/android/Manifest.permission?hl=es-419
 * @author Yesid Melo
 */
@SuppressLint("InlinedApi")
enum class Permisos (private val NombrePermiso : String, private val requestCode : Int) {
    ACCEPT_HANDOVER(Manifest.permission.ACCEPT_HANDOVER,300),
    ACCESS_BACKGROUND_LOCATION(Manifest.permission.ACCESS_BACKGROUND_LOCATION,300),
    ACCESS_CHECKIN_PROPERTIES(Manifest.permission.ACCESS_CHECKIN_PROPERTIES,300),
    ACCESS_COARSE_LOCATION(Manifest.permission.ACCESS_COARSE_LOCATION,300),
    ACCESS_FINE_LOCATION(Manifest.permission.ACCESS_FINE_LOCATION,300),
    ACCESS_LOCATION_EXTRA_COMMANDS(Manifest.permission.ACCESS_LOCATION_EXTRA_COMMANDS,300),
    ACCESS_MEDIA_LOCATION(Manifest.permission.ACCESS_MEDIA_LOCATION,300),
    ACCESS_NETWORK_STATE(Manifest.permission.ACCESS_NETWORK_STATE,300),
    ACCESS_WIFI_STATE(Manifest.permission.ACCESS_WIFI_STATE,300),
    ACCOUNT_MANAGER(Manifest.permission.ACCOUNT_MANAGER,300),
    ACTIVITY_RECOGNITION(Manifest.permission.ACTIVITY_RECOGNITION,300),
    ADD_VOICEMAIL(Manifest.permission.ADD_VOICEMAIL,300),
    ANSWER_PHONE_CALLS(Manifest.permission.ANSWER_PHONE_CALLS,300),
    BATTERY_STATS(Manifest.permission.BATTERY_STATS,300),
    BIND_ACCESSIBILITY_SERVICE(Manifest.permission.BIND_ACCESSIBILITY_SERVICE,300),
    BIND_APPWIDGET(Manifest.permission.BIND_APPWIDGET,300),
    BIND_AUTOFILL_SERVICE(Manifest.permission.BIND_AUTOFILL_SERVICE,300),
    BIND_CALL_REDIRECTION_SERVICE(Manifest.permission.BIND_CALL_REDIRECTION_SERVICE,300),
    BIND_CARRIER_MESSAGING_CLIENT_SERVICE(Manifest.permission.BIND_CARRIER_MESSAGING_CLIENT_SERVICE,300),
    BIND_CARRIER_MESSAGING_SERVICE(Manifest.permission.BIND_CARRIER_MESSAGING_SERVICE,300),
    BIND_CARRIER_SERVICES(Manifest.permission.BIND_CARRIER_SERVICES,300),
    BIND_CHOOSER_TARGET_SERVICE(Manifest.permission.BIND_CHOOSER_TARGET_SERVICE,300),
    BIND_CONDITION_PROVIDER_SERVICE(Manifest.permission.BIND_CONDITION_PROVIDER_SERVICE,300),
    BIND_DEVICE_ADMIN(Manifest.permission.BIND_DEVICE_ADMIN,300),
    BIND_DREAM_SERVICE(Manifest.permission.BIND_DREAM_SERVICE,300),
    BIND_INCALL_SERVICE(Manifest.permission.BIND_INCALL_SERVICE,300),
    BIND_INPUT_METHOD(Manifest.permission.BIND_INPUT_METHOD,300),
    BIND_MIDI_DEVICE_SERVICE(Manifest.permission.BIND_MIDI_DEVICE_SERVICE,300),
    BIND_NFC_SERVICE(Manifest.permission.BIND_NFC_SERVICE,300),
    BIND_NOTIFICATION_LISTENER_SERVICE(Manifest.permission.BIND_NOTIFICATION_LISTENER_SERVICE,300),
    BIND_PRINT_SERVICE(Manifest.permission.BIND_PRINT_SERVICE,300),
    BIND_QUICK_SETTINGS_TILE(Manifest.permission.BIND_QUICK_SETTINGS_TILE,300),
    BIND_REMOTEVIEWS(Manifest.permission.BIND_REMOTEVIEWS,300),
    BIND_SCREENING_SERVICE(Manifest.permission.BIND_SCREENING_SERVICE,300),
    BIND_TELECOM_CONNECTION_SERVICE(Manifest.permission.BIND_TELECOM_CONNECTION_SERVICE,300),
    BIND_TEXT_SERVICE(Manifest.permission.BIND_TEXT_SERVICE,300),
    BIND_TV_INPUT(Manifest.permission.BIND_TV_INPUT,300),
    BIND_VISUAL_VOICEMAIL_SERVICE(Manifest.permission.BIND_VISUAL_VOICEMAIL_SERVICE,300),
    BIND_VOICE_INTERACTION(Manifest.permission.BIND_VOICE_INTERACTION,300),
    BIND_VPN_SERVICE(Manifest.permission.BIND_VPN_SERVICE,300),
    BIND_VR_LISTENER_SERVICE(Manifest.permission.BIND_VR_LISTENER_SERVICE,300),
    BIND_WALLPAPER(Manifest.permission.BIND_WALLPAPER,300),
    BLUETOOTH(Manifest.permission.BLUETOOTH,300),
    BLUETOOTH_ADMIN(Manifest.permission.BLUETOOTH_ADMIN,300),
    BLUETOOTH_PRIVILEGED(Manifest.permission.BLUETOOTH_PRIVILEGED,300),
    BODY_SENSORS(Manifest.permission.BODY_SENSORS,300),
    BROADCAST_PACKAGE_REMOVED(Manifest.permission.BROADCAST_PACKAGE_REMOVED,300),
    BROADCAST_SMS(Manifest.permission.BROADCAST_SMS,300),
    BROADCAST_STICKY(Manifest.permission.BROADCAST_STICKY,300),
    BROADCAST_WAP_PUSH(Manifest.permission.BROADCAST_WAP_PUSH,300),
    CALL_COMPANION_APP(Manifest.permission.CALL_COMPANION_APP,300),
    CALL_PHONE(Manifest.permission.CALL_PHONE,300),
    CALL_PRIVILEGED(Manifest.permission.CALL_PRIVILEGED,300),
    CAMERA(Manifest.permission.CAMERA,300),
    CAPTURE_AUDIO_OUTPUT(Manifest.permission.CAPTURE_AUDIO_OUTPUT,300),
    CHANGE_COMPONENT_ENABLED_STATE(Manifest.permission.CHANGE_COMPONENT_ENABLED_STATE,300),
    CHANGE_CONFIGURATION(Manifest.permission.CHANGE_CONFIGURATION,300),
    CHANGE_NETWORK_STATE(Manifest.permission.CHANGE_NETWORK_STATE,300),
    CHANGE_WIFI_MULTICAST_STATE(Manifest.permission.CHANGE_WIFI_MULTICAST_STATE,300),
    CHANGE_WIFI_STATE(Manifest.permission.CHANGE_WIFI_STATE,300),
    CLEAR_APP_CACHE(Manifest.permission.CLEAR_APP_CACHE,300),
    CONTROL_LOCATION_UPDATES(Manifest.permission.CONTROL_LOCATION_UPDATES,300),
    DELETE_CACHE_FILES(Manifest.permission.DELETE_CACHE_FILES,300),
    DELETE_PACKAGES(Manifest.permission.DELETE_PACKAGES,300),
    DIAGNOSTIC(Manifest.permission.DIAGNOSTIC,300),
    DISABLE_KEYGUARD(Manifest.permission.DISABLE_KEYGUARD,300),
    DUMP(Manifest.permission.DUMP,300),
    EXPAND_STATUS_BAR(Manifest.permission.EXPAND_STATUS_BAR,300),
    FACTORY_TEST(Manifest.permission.FACTORY_TEST,300),
    FOREGROUND_SERVICE(Manifest.permission.FOREGROUND_SERVICE,300),
    GET_ACCOUNTS(Manifest.permission.GET_ACCOUNTS,300),
    GET_ACCOUNTS_PRIVILEGED(Manifest.permission.GET_ACCOUNTS_PRIVILEGED,300),
    GET_PACKAGE_SIZE(Manifest.permission.GET_PACKAGE_SIZE,300),
    GET_TASKS(Manifest.permission.GET_TASKS,300),
    GLOBAL_SEARCH(Manifest.permission.GLOBAL_SEARCH,300),
    INSTALL_LOCATION_PROVIDER(Manifest.permission.INSTALL_LOCATION_PROVIDER,300),
    INSTALL_PACKAGES(Manifest.permission.INSTALL_PACKAGES,300),
    INSTALL_SHORTCUT(Manifest.permission.INSTALL_SHORTCUT,300),
    INSTANT_APP_FOREGROUND_SERVICE(Manifest.permission.INSTANT_APP_FOREGROUND_SERVICE,300),
    INTERNET(Manifest.permission.INTERNET,300),
    KILL_BACKGROUND_PROCESSES(Manifest.permission.KILL_BACKGROUND_PROCESSES,300),
    LOCATION_HARDWARE(Manifest.permission.LOCATION_HARDWARE,300),
    MANAGE_DOCUMENTS(Manifest.permission.MANAGE_DOCUMENTS,300),
    MANAGE_OWN_CALLS(Manifest.permission.MANAGE_OWN_CALLS,300),
    MASTER_CLEAR(Manifest.permission.MASTER_CLEAR,300),
    MEDIA_CONTENT_CONTROL(Manifest.permission.MEDIA_CONTENT_CONTROL,300),
    MODIFY_AUDIO_SETTINGS(Manifest.permission.MODIFY_AUDIO_SETTINGS,300),
    MODIFY_PHONE_STATE(Manifest.permission.MODIFY_PHONE_STATE,300),
    MOUNT_FORMAT_FILESYSTEMS(Manifest.permission.MOUNT_FORMAT_FILESYSTEMS,300),
    MOUNT_UNMOUNT_FILESYSTEMS(Manifest.permission.MOUNT_UNMOUNT_FILESYSTEMS,300),
    NFC(Manifest.permission.NFC,300),
    NFC_TRANSACTION_EVENT(Manifest.permission.NFC_TRANSACTION_EVENT,300),
    PACKAGE_USAGE_STATS(Manifest.permission.PACKAGE_USAGE_STATS,300),
    PERSISTENT_ACTIVITY(Manifest.permission.PERSISTENT_ACTIVITY,300),
    PROCESS_OUTGOING_CALLS(Manifest.permission.PROCESS_OUTGOING_CALLS,300),
    READ_CALENDAR(Manifest.permission.READ_CALENDAR,300),
    READ_CALL_LOG(Manifest.permission.READ_CALL_LOG,300),
    READ_CONTACTS(Manifest.permission.READ_CONTACTS,300),
    READ_EXTERNAL_STORAGE(Manifest.permission.READ_EXTERNAL_STORAGE,300),
    READ_INPUT_STATE(Manifest.permission.READ_INPUT_STATE,300),
    READ_LOGS(Manifest.permission.READ_LOGS,300),
    READ_PHONE_NUMBERS(Manifest.permission.READ_PHONE_NUMBERS,300),
    READ_PHONE_STATE(Manifest.permission.READ_PHONE_STATE,300),
    READ_SMS(Manifest.permission.READ_SMS,300),
    READ_SYNC_SETTINGS(Manifest.permission.READ_SYNC_SETTINGS,300),
    READ_SYNC_STATS(Manifest.permission.READ_SYNC_STATS,300),
    READ_VOICEMAIL(Manifest.permission.READ_VOICEMAIL,300),
    REBOOT(Manifest.permission.REBOOT,300),
    RECEIVE_BOOT_COMPLETED(Manifest.permission.RECEIVE_BOOT_COMPLETED,300),
    RECEIVE_MMS(Manifest.permission.RECEIVE_MMS,300),
    RECEIVE_SMS(Manifest.permission.RECEIVE_SMS,300),
    RECEIVE_WAP_PUSH(Manifest.permission.RECEIVE_WAP_PUSH,300),
    RECORD_AUDIO(Manifest.permission.RECORD_AUDIO,300),
    REORDER_TASKS(Manifest.permission.REORDER_TASKS,300),
    REQUEST_COMPANION_RUN_IN_BACKGROUND(Manifest.permission.REQUEST_COMPANION_RUN_IN_BACKGROUND,300),
    REQUEST_COMPANION_USE_DATA_IN_BACKGROUND(Manifest.permission.REQUEST_COMPANION_USE_DATA_IN_BACKGROUND,300),
    REQUEST_DELETE_PACKAGES(Manifest.permission.REQUEST_DELETE_PACKAGES,300),
    REQUEST_IGNORE_BATTERY_OPTIMIZATIONS(Manifest.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS,300),
    REQUEST_INSTALL_PACKAGES(Manifest.permission.REQUEST_INSTALL_PACKAGES,300),
    REQUEST_PASSWORD_COMPLEXITY(Manifest.permission.REQUEST_PASSWORD_COMPLEXITY,300),
    RESTART_PACKAGES(Manifest.permission.RESTART_PACKAGES,300),
    SEND_RESPOND_VIA_MESSAGE(Manifest.permission.SEND_RESPOND_VIA_MESSAGE,300),
    SEND_SMS(Manifest.permission.SEND_SMS,300),
    SET_ALARM(Manifest.permission.SET_ALARM,300),
    SET_ALWAYS_FINISH(Manifest.permission.SET_ALWAYS_FINISH,300),
    SET_ANIMATION_SCALE(Manifest.permission.SET_ANIMATION_SCALE,300),
    SET_DEBUG_APP(Manifest.permission.SET_DEBUG_APP,300),
    SET_PREFERRED_APPLICATIONS(Manifest.permission.SET_PREFERRED_APPLICATIONS,300),
    SET_PROCESS_LIMIT(Manifest.permission.SET_PROCESS_LIMIT,300),
    SET_TIME(Manifest.permission.SET_TIME,300),
    SET_TIME_ZONE(Manifest.permission.SET_TIME_ZONE,300),
    SET_WALLPAPER(Manifest.permission.SET_WALLPAPER,300),
    SET_WALLPAPER_HINTS(Manifest.permission.SET_WALLPAPER_HINTS,300),
    SIGNAL_PERSISTENT_PROCESSES(Manifest.permission.SIGNAL_PERSISTENT_PROCESSES,300),
    SMS_FINANCIAL_TRANSACTIONS(Manifest.permission.SMS_FINANCIAL_TRANSACTIONS,300),
    STATUS_BAR(Manifest.permission.STATUS_BAR,300),
    SYSTEM_ALERT_WINDOW(Manifest.permission.SYSTEM_ALERT_WINDOW,300),
    TRANSMIT_IR(Manifest.permission.TRANSMIT_IR,300),
    UNINSTALL_SHORTCUT(Manifest.permission.UNINSTALL_SHORTCUT,300),
    UPDATE_DEVICE_STATS(Manifest.permission.UPDATE_DEVICE_STATS,300),
    USE_BIOMETRIC(Manifest.permission.USE_BIOMETRIC,300),
    USE_FINGERPRINT(Manifest.permission.USE_FINGERPRINT,300),
    USE_FULL_SCREEN_INTENT(Manifest.permission.USE_FULL_SCREEN_INTENT,300),
    USE_SIP(Manifest.permission.USE_SIP,300),
    VIBRATE(Manifest.permission.VIBRATE,300),
    WAKE_LOCK(Manifest.permission.WAKE_LOCK,300),
    WRITE_APN_SETTINGS(Manifest.permission.WRITE_APN_SETTINGS,300),
    WRITE_CALENDAR(Manifest.permission.WRITE_CALENDAR,300),
    WRITE_CALL_LOG(Manifest.permission.WRITE_CALL_LOG,300),
    WRITE_CONTACTS(Manifest.permission.WRITE_CONTACTS,300),
    WRITE_EXTERNAL_STORAGE(Manifest.permission.WRITE_EXTERNAL_STORAGE,300),
    WRITE_GSERVICES(Manifest.permission.WRITE_GSERVICES,300),
    WRITE_SECURE_SETTINGS(Manifest.permission.WRITE_SECURE_SETTINGS,300),
    WRITE_SETTINGS(Manifest.permission.WRITE_SETTINGS,300),
    WRITE_SYNC_SETTINGS(Manifest.permission.WRITE_SYNC_SETTINGS,300),
    WRITE_VOICEMAIL(Manifest.permission.WRITE_VOICEMAIL,300),




    ;

    fun traerNombrePermisoManifiest() : String{
        return NombrePermiso
    }

    fun traerRequestCode() : Int{
        return requestCode
    }


}