### plugin veridex

```
buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath "io.github.lizhangqu:plugin-veridex:1.0.1"
    }
}

apply plugin: 'veridex'
```

Execute veridex gradle task

```
gradlew veridexDebug
#or gradlew veridexRelease
```

Example output

```
#1: Reflection greylist Landroid/content/res/Resources;->mResourcesImpl use(s):
       Landroid/support/v7/app/ResourcesFlusher;->flushNougats(Landroid/content/res/Resources;)Z

#2: Reflection greylist Landroid/graphics/FontFamily;->abortCreation use(s):
       Landroid/support/v4/graphics/TypefaceCompatApi26Impl;-><clinit>()V

#3: Reflection greylist Landroid/graphics/FontFamily;->addFontFromAssetManager use(s):
       Landroid/support/v4/graphics/TypefaceCompatApi26Impl;-><clinit>()V

#4: Reflection greylist Landroid/graphics/FontFamily;->addFontFromBuffer use(s):
       Landroid/support/v4/graphics/TypefaceCompatApi26Impl;-><clinit>()V

#5: Reflection greylist Landroid/graphics/FontFamily;->freeze use(s):
       Landroid/support/v4/graphics/TypefaceCompatApi26Impl;-><clinit>()V

#6: Reflection greylist Landroid/graphics/Typeface;->createFromFamiliesWithDefault use(s):
       Landroid/support/v4/graphics/TypefaceCompatApi24Impl;-><clinit>()V
       Landroid/support/v4/graphics/TypefaceCompatApi26Impl;-><clinit>()V

#7: Reflection greylist Landroid/os/Bundle;->getIBinder use(s):
       Landroid/support/v4/app/BundleCompat$BundleCompatBaseImpl;->getBinder(Landroid/os/Bundle;Ljava/lang/String;)Landroid/os/IBinder;

#8: Reflection greylist Landroid/os/Bundle;->putIBinder use(s):
       Landroid/support/v4/app/BundleCompat$BundleCompatBaseImpl;->putBinder(Landroid/os/Bundle;Ljava/lang/String;Landroid/os/IBinder;)V

#9: Reflection greylist Landroid/view/LayoutInflater;->mFactory2 use(s):
       Landroid/support/v4/view/LayoutInflaterCompat;->forceSetFactory2(Landroid/view/LayoutInflater;Landroid/view/LayoutInflater$Factory2;)V

#10: Reflection greylist Landroid/view/View;->computeFitSystemWindows use(s):
       Landroid/support/v7/widget/ViewUtils;-><clinit>()V

#11: Reflection greylist Landroid/view/View;->mAccessibilityDelegate use(s):
       Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;->hasAccessibilityDelegate(Landroid/view/View;)Z

#12: Reflection greylist-max-p Landroid/view/View;->mMinHeight use(s):
       Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;->getMinimumHeight(Landroid/view/View;)I

#13: Reflection greylist-max-p Landroid/view/View;->mMinWidth use(s):
       Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;->getMinimumWidth(Landroid/view/View;)I

#14: Reflection greylist Landroid/view/View;->mRecreateDisplayList use(s):
       Landroid/support/v4/widget/SlidingPaneLayout$SlidingPanelLayoutImplJB;-><init>()V

#15: Reflection greylist-max-p Landroid/view/animation/Animation;->mListener use(s):
       Landroid/support/v4/app/FragmentManagerImpl;->getAnimationListener(Landroid/view/animation/Animation;)Landroid/view/animation/Animation$AnimationListener;

#16: Reflection greylist Landroid/widget/AbsListView;->mIsChildViewEnabled use(s):
       Landroid/support/v7/widget/DropDownListView;-><init>(Landroid/content/Context;Z)V

#17: Reflection greylist-max-p Landroid/widget/AutoCompleteTextView;->doAfterTextChanged use(s):
       Landroid/support/v7/widget/SearchView$AutoCompleteTextViewReflector;-><init>()V

#18: Reflection greylist-max-p Landroid/widget/AutoCompleteTextView;->doBeforeTextChanged use(s):
       Landroid/support/v7/widget/SearchView$AutoCompleteTextViewReflector;-><init>()V

#19: Reflection greylist-max-p Landroid/widget/AutoCompleteTextView;->ensureImeVisible use(s):
       Landroid/support/v7/widget/SearchView$AutoCompleteTextViewReflector;-><init>()V

#20: Reflection greylist Landroid/widget/CompoundButton;->mButtonDrawable use(s):
       Landroid/support/v4/widget/CompoundButtonCompat$CompoundButtonCompatBaseImpl;->getButtonDrawable(Landroid/widget/CompoundButton;)Landroid/graphics/drawable/Drawable;

#21: Reflection greylist-max-p Landroid/widget/PopupWindow;->mOverlapAnchor use(s):
       Landroid/support/v4/widget/PopupWindowCompat$PopupWindowCompatApi21Impl;-><clinit>()V

#22: Reflection greylist-max-p Landroid/widget/TextView;->getHorizontallyScrolling use(s):
       Landroid/support/v7/widget/AppCompatTextViewAutoSizeHelper;->autoSizeText()V

#23: Reflection greylist Landroid/widget/TextView;->getLayoutAlignment use(s):
       Landroid/support/v7/widget/AppCompatTextViewAutoSizeHelper;->suggestedSizeFitsInSpace(ILandroid/graphics/RectF;)Z

#24: Reflection greylist Landroid/widget/TextView;->mMaxMode use(s):
       Landroid/support/v4/widget/TextViewCompat$TextViewCompatBaseImpl;->getMaxLines(Landroid/widget/TextView;)I

#25: Reflection greylist Landroid/widget/TextView;->mMaximum use(s):
       Landroid/support/v4/widget/TextViewCompat$TextViewCompatBaseImpl;->getMaxLines(Landroid/widget/TextView;)I
       Landroid/support/v4/widget/TextViewCompat$TextViewCompatBaseImpl;->getMaxLines(Landroid/widget/TextView;)I

#26: Reflection greylist Landroid/widget/TextView;->mMinMode use(s):
       Landroid/support/v4/widget/TextViewCompat$TextViewCompatBaseImpl;->getMinLines(Landroid/widget/TextView;)I

#27: Reflection greylist Landroid/widget/TextView;->mMinimum use(s):
       Landroid/support/v4/widget/TextViewCompat$TextViewCompatBaseImpl;->getMinLines(Landroid/widget/TextView;)I
       Landroid/support/v4/widget/TextViewCompat$TextViewCompatBaseImpl;->getMinLines(Landroid/widget/TextView;)I

#28: Reflection greylist Landroid/widget/TextView;->nullLayouts use(s):
       Landroid/support/v7/widget/AppCompatTextViewAutoSizeHelper;->setRawTextSize(F)V

#29: Reflection greylist Llibcore/icu/ICU;->addLikelySubtags use(s):
       Landroid/support/v4/text/ICUCompat;-><clinit>()V

29 hidden API(s) used: 0 linked against, 29 through reflection
       21 in greylist
       0 in blacklist
       0 in greylist-max-o
       8 in greylist-max-p
To run an analysis that can give more reflection accesses, 
but could include false positives, pass the --imprecise flag.
```

### Thanks
 
 - [appcompat](https://android.googlesource.com/platform/prebuilts/runtime/+/master/appcompat)