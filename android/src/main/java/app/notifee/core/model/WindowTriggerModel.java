package app.notifee.core.model;

/*
 * Copyright (c) 2016-present Invertase Limited & Contributors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this library except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

import android.os.Bundle;
import androidx.annotation.NonNull;
import app.notifee.core.utility.ObjectUtils;
import java.util.concurrent.TimeUnit;

public class WindowTriggerModel {
  private Bundle mWindowTriggerBundle;
  private Boolean mWithAlarmManager = true;
  private AlarmType mAlarmType = AlarmType.SET_WINDOW;
  private Long mTimestamp = null;
  private Long mWindowDuration = null;

  private static final String TAG = "TimeTriggerModel";

  private WindowTriggerModel(Bundle bundle) {
    mWindowTriggerBundle = bundle;
    mAlarmType = AlarmType.SET_WINDOW;
    mTimestamp = ObjectUtils.getLong(mWindowTriggerBundle.get("timestamp"));
    mWindowDuration = ObjectUtils.getLong(mWindowTriggerBundle.get("windowDuration"));
  }

  public static WindowTriggerModel fromBundle(@NonNull Bundle bundle) {
    return new WindowTriggerModel(bundle);
  }

  public long getTimestamp() {
    return mTimestamp;
  }

  public long getWindowDuration() {
    return mWindowDuration;
  }

  public AlarmType getAlarmType() {
    return mAlarmType;
  }

  public enum AlarmType {
    SET_WINDOW
  }

  public Bundle toBundle() {
    return (Bundle) mWindowTriggerBundle.clone();
  }
}
