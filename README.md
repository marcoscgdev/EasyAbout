# EasyAbout
Fully material-designed about fragment for your application.

**More info coming soon...**

---

## Releases:

#### Current release: 1.0.4.

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
implementation 'com.github.marcoscgdev:EasyAbout:1.0.4'
```

### Create the fragment

Your about fragment **must extend** from _EasyAboutFragment_

```java
public class AboutFragment extends EasyAboutFragment {

    @Override
    protected void configureFragment(final Context context, View rootView) {
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

[1]: https://raw.githubusercontent.com/marcoscgdev/EasyAbout/master/screenshots/1.png
[2]: https://raw.githubusercontent.com/marcoscgdev/EasyAbout/master/screenshots/2.png
[3]: https://raw.githubusercontent.com/marcoscgdev/EasyAbout/master/screenshots/3.png
