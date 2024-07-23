#
# Copyright (C) 2017 The LineageOS Project
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

# Boot animation
TARGET_SCREEN_HEIGHT := 800
TARGET_SCREEN_WIDTH := 1280

$(call inherit-product, $(SRC_TARGET_DIR)/product/core_64_bit.mk)

# Inherit from those products. Most specific first.
$(call inherit-product, $(SRC_TARGET_DIR)/product/full_base.mk)
$(call inherit-product, $(SRC_TARGET_DIR)/product/product_launched_with_o_mr1.mk)
$(call inherit-product, device/lenovo/sparrow/verity.mk)

# Inherit some common LineageOS stuff.
$(call inherit-product, vendor/lineage/config/common_full_phone.mk)

# Inherit device configuration
$(call inherit-product, device/lenovo/sparrow/device.mk)

# Device identifier. This must come after all inclusions
PRODUCT_NAME := lineage_sparrow
PRODUCT_DEVICE := sparrow
PRODUCT_BRAND := Lenovo
PRODUCT_MODEL := Lenovo SD-X701B
PRODUCT_MANUFACTURER := Lenovo

PRODUCT_GMS_CLIENTID_BASE := android-lenovo

PRODUCT_BUILD_PROP_OVERRIDES += \
    PRIVATE_BUILD_DESC="msm8953_64-userdebug 8.1.0 OPM1.171019.011 SPARROWPR test-keys" \
    TARGET_DEVICE="msm8953_64"

BUILD_FINGERPRINT := Android/msm8953_64/msm8953_64:8.1.0/OPM1.171019.011/SPARROWPR:userdebug/test-keys
