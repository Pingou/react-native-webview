package com.reactnativecommunity.webview.events

import com.facebook.react.bridge.WritableMap
import com.facebook.react.uimanager.events.Event
import com.facebook.react.uimanager.events.RCTEventEmitter

/**
 * Event emitted when the WebView wants to download a file (Android).
 * Mirrors the iOS onFileDownload event so the JS side can handle
 * downloads itself instead of the system DownloadManager.
 */
class TopFileDownloadEvent(viewId: Int, private val mEventData: WritableMap) :
  Event<TopFileDownloadEvent>(viewId) {
  companion object {
    const val EVENT_NAME = "topFileDownload"
  }

  override fun getEventName(): String = EVENT_NAME

  override fun canCoalesce(): Boolean = false

  override fun getCoalescingKey(): Short = 0

  override fun dispatch(rctEventEmitter: RCTEventEmitter) =
    rctEventEmitter.receiveEvent(viewTag, eventName, mEventData)
}
