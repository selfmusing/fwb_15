/*
 * Copyright (C) 2023 The Android Open Source Project
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

package com.android.systemui.bouncer.domain.interactor

import com.android.keyguard.keyguardUpdateMonitor
import com.android.systemui.biometrics.data.repository.fingerprintPropertyRepository
import com.android.systemui.bouncer.data.repository.keyguardBouncerRepository
import com.android.systemui.deviceentry.domain.interactor.deviceEntryFingerprintAuthInteractor
import com.android.systemui.keyguard.data.repository.biometricSettingsRepository
import com.android.systemui.keyguard.domain.interactor.keyguardInteractor
import com.android.systemui.keyguard.domain.interactor.keyguardTransitionInteractor
import com.android.systemui.kosmos.Kosmos
import com.android.systemui.kosmos.testScope
import com.android.systemui.plugins.statusbar.statusBarStateController
import com.android.systemui.scene.domain.interactor.sceneInteractor
import com.android.systemui.statusbar.policy.keyguardStateController
import com.android.systemui.util.time.systemClock

val Kosmos.alternateBouncerInteractor: AlternateBouncerInteractor by
    Kosmos.Fixture {
        AlternateBouncerInteractor(
            statusBarStateController = statusBarStateController,
            keyguardStateController = keyguardStateController,
            bouncerRepository = keyguardBouncerRepository,
            fingerprintPropertyRepository = fingerprintPropertyRepository,
            biometricSettingsRepository = biometricSettingsRepository,
            systemClock = systemClock,
            keyguardUpdateMonitor = keyguardUpdateMonitor,
            deviceEntryFingerprintAuthInteractor = { deviceEntryFingerprintAuthInteractor },
            keyguardInteractor = { keyguardInteractor },
            keyguardTransitionInteractor = { keyguardTransitionInteractor },
            scope = testScope.backgroundScope,
            sceneInteractor = { sceneInteractor },
        )
    }
