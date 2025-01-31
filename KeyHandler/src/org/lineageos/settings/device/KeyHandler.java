/*
 * Copyright (C) 2018 The LineageOS Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.lineageos.settings.device;

import android.content.Context;
import android.media.AudioManager;
import android.view.KeyEvent;
import android.util.Log;

import com.android.internal.os.DeviceKeyHandler;

public class KeyHandler implements DeviceKeyHandler {
    private static final String TAG = KeyHandler.class.getSimpleName();

    // Slider key codes
    private static final int MODE_NORMAL = 601;
    private static final int MODE_VIBRATION = 602;
    private static final int MODE_SILENCE = 603;

    private final Context mContext;
    private final AudioManager mAudioManager;

    public KeyHandler(Context context) {
        mContext = context;

        mAudioManager = mContext.getSystemService(AudioManager.class);
    }

    public KeyEvent handleKeyEvent(KeyEvent event) {
        int scanCode = event.getScanCode();

        Log.d(TAG, "DEBUG: action=" + event.getAction()
            + ", flags=" + event.getFlags()
            + ", keyCode=" + event.getKeyCode()
            + ", scanCode=" + event.getScanCode()
            + ", metaState=" + event.getMetaState()
            + ", repeatCount=" + event.getRepeatCount());

        switch (scanCode) {
            case MODE_NORMAL:
                Log.d(TAG, "601");
                mAudioManager.setRingerModeInternal(AudioManager.RINGER_MODE_NORMAL);
                break;
            case MODE_VIBRATION:
                Log.d(TAG, "602");
                mAudioManager.setRingerModeInternal(AudioManager.RINGER_MODE_VIBRATE);
                break;
            case MODE_SILENCE:
                Log.d(TAG, "603");
                mAudioManager.setRingerModeInternal(AudioManager.RINGER_MODE_SILENT);
                break;
            default:
                return event;
        }

        return null;
    }
}
