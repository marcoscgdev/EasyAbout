# EasyAbout
Fully material-designed about fragment for your application.

---

## Releases:

#### Current release: 1.0.5.

You can see all the library releases [here](https://github.com/marcoscgdev/EasyAbout/releases).

---

## Demo:

You can download the **sample apk** [here](https://github.com/marcoscgdev/Licenser/releases/download/1.0.2/app-debug.apk).

| Default | Default Dark | Colored |
|----------|----------|----------|
| ![Sample App][1] | ![Sample App][2] | ![Sample App][3] |

---

## Usage:

### Adding the depencency

Add this to your root *build.gradle* file:

```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

Now add the dependency to your app build.gradle file:

```
implementation 'com.github.marcoscgdev:EasyAbout:1.0.5'
```

### Create the fragment

Your about fragment **must extend** from _EasyAboutFragment_

```java
public class AboutFragment extends EasyAboutFragment {

    @Override
    protected void configureFragment(final Context context, View rootView, Bundle savedInstanceState) {
        // add cards here
    }
}
```

### Create a card

**Note: all parameters are optional**

```java
AboutCard aboutCard = new AboutCard.Builder(context)
        .setTitle("Card title") // It can also be passed as a string resource
        .setTitleColorRes(R.color.colorAccent) // You can also use setTitleColor(int color);
        .addItem(personAboutItem)
        .addItem(normalAboutItem)
        .build();
```

### Create a item

**Note: all parameters are optional and common for all item types**

#### Header item

```java
HeaderAboutItem headerAboutItem = new HeaderAboutItem.Builder(context)
        .setTitle(R.string.app_name) // It can also be passed as a string value
        .setSubtitle(BuildConfig.VERSION_NAME) // It can also be passed as a string resource
        .setIcon(R.mipmap.ic_launcher) // It can also be passed as a drawable
        .build();
```

#### Normal item

```java
NormalAboutItem normalAboutItem = new NormalAboutItem.Builder(context)
        .setTitle("Item title") // It can also be passed as a string resource
        .setSubtitle("Item subtitle") // It can also be passed as a string resource
        .setIcon(R.drawable.ic_info_outline_black_24dp) // It can also be passed as a drawable
        .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Your click action here
            }
        })
        .setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                // Your long click action here
                return false;
            }
        })
        .build();
```

#### Person item

```java
PersonAboutItem personAboutItem = new PersonAboutItem.Builder(context)
        .setTitle("Your name here") // It can also be passed as a string resource
        .setSubtitle("Your info here") // It can also be passed as a string resource
        .setIcon(R.drawable.user) // It can also be passed as a drawable
        .build();
```

### Add cards to the fragment

You can add cards with the _addCard(AboutCard aboutCard);_ method (inside the configureFragment function of the fragment)

```java
NormalAboutItem normalAboutItem = new NormalAboutItem.Builder(context)
        .setTitle("Item title")
        .setSubtitle("Item subtitle")
        .setIcon(R.drawable.ic_info_outline_black_24dp)
        .build();
        
addCard(normalAboutItem);
```

### Sample fragment

```java
public class AboutFragment extends EasyAboutFragment {

    @Override
    protected void configureFragment(final Context context, View rootView, Bundle savedInstanceState) {
        addCard(new AboutCard.Builder(context)
                .addItem(AboutItemBuilder.generateAppTitleItem(context)
                        .setSubtitle("by @MarcosCGdev."))
                .addItem(AboutItemBuilder.generateAppVersionItem(context, true)
                        .setIcon(R.drawable.ic_info_outline_black_24dp))
                .addItem(new NormalAboutItem.Builder(context)
                        .setTitle("Licenses")
                        .setIcon(R.drawable.ic_description_black_24dp)
                        .setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                DemoUtils.showLicensesDialog(context);
                            }
                        })
                        .build())
                .build());
                
        addCard(new AboutCard.Builder(context)
                .setTitle("Support")
                .addItem(AboutItemBuilder.generatePlayStoreItem(context)
                        .setTitle("Rate application")
                        .setIcon(R.drawable.ic_star_black_24dp))
                .addItem(AboutItemBuilder.generateLinkItem(context, "https://github.com/marcoscgdev/EasyAbout/issues/new")
                        .setTitle("Report bugs")
                        .setIcon(R.drawable.ic_bug_report_black_24dp))
                .addItem(new NormalAboutItem.Builder(context)
                        .setTitle("Clickable item")
                        .setSubtitle("This item has onClick and onLongClick listener.")
                        .setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast.makeText(context, "onClick", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setOnLongClickListener(new View.OnLongClickListener() {
                            @Override
                            public boolean onLongClick(View view) {
                                Toast.makeText(context, "onLongClick", Toast.LENGTH_SHORT).show();
                                return false;
                            }
                        })
                        .setIcon(R.drawable.ic_mouse_black_24dp)
                        .build())
                .build());
    }
}
```

### Customize card color

Simply add this to your app theme. Replace _@color/colorPrimary_ with your desired color.

```xml
<item name="aboutCardBackground">@color/colorPrimary</item>
```

---
>See the *sample project* to clarify any queries you may have.

---

## License

```
MIT License

Copyright (c) 2018 Marcos Calvo García

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```

[1]: https://raw.githubusercontent.com/marcoscgdev/EasyAbout/master/screenshots/1.png
[2]: https://raw.githubusercontent.com/marcoscgdev/EasyAbout/master/screenshots/2.png
[3]: https://raw.githubusercontent.com/marcoscgdev/EasyAbout/master/screenshots/3.png
