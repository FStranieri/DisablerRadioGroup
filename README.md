# DisablerRadioGroup

## Importing with Gradle

`compile 'com.fstranieri.disablerradiogroup:disablerradiogroup:1.0'`

## Usage



        <com.fstranieri.disablerradiogroup.DisablerRadioGroup
         xmlns:custom="@string/NS"
         android:id="@+id/radiogroup"
         android:layout_width="wrap_content"
         android:layout_height="wrap_content"
         custom:dependentViewId="@+id/spinner" //it indicates which view has to be disabled
         custom:disablerRadio="@+id/radio2"  //it indicates which radiobutton has to disable the view
         >

        <RadioButton
            android:id="@+id/radio1"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="RADIO 1"
            />
        <RadioButton
            android:id="@+id/radio2"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="RADIO 2"
            />

    </com.fstranieri.disablerradiogroup.DisablerRadioGroup>

    <Spinner
        android:id="@+id/spinner"
        android:layout_below="@+id/radiogroup"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"></Spinner>

## LICENSE

> Copyright 2016 Francesco Stranieri

> Licensed under the Apache License, Version 2.0 (the "License");
> you may not use this file except in compliance with the License.
> You may obtain a copy of the License at

>    http://www.apache.org/licenses/LICENSE-2.0

> Unless required by applicable law or agreed to in writing, software
> distributed under the License is distributed on an "AS IS" BASIS,
> WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
> See the License for the specific language governing permissions and
> limitations under the License.
