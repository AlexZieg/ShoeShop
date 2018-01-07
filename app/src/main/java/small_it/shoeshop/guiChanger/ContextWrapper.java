package small_it.shoeshop.guiChanger;


import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.LocaleList;


import java.util.Locale;

/**
 * Class to change the current Configuration to set the new Language through the app
 *
 * Warning contains deprecated Methods as long as Google won't support in app
 * Language changes
 */
public class ContextWrapper extends android.content.ContextWrapper{


    public ContextWrapper(Context base) {
        super(base);
    }

    /**
     * Method to change the Language Settings within the App
     * @param context Actual context
     * @param newLocale Location of the Language e.g. "en" for English, "de" for German
     * @return .
     */
    @Deprecated
    public static ContextWrapper wrap (Context context, Locale newLocale){

        Resources res = context.getResources();
        Configuration configuration = res.getConfiguration();


        if (Build.VERSION.SDK_INT < 24) {
            context = context.createConfigurationContext(config(configuration, newLocale));
        } else if (Build.VERSION.SDK_INT < 17 && Build.VERSION.SDK_INT > 24) {
            configuration.setLocale(newLocale);
            context = context.createConfigurationContext(configuration);

        } else {
            configuration.locale = newLocale;
            res.updateConfiguration(configuration, res.getDisplayMetrics());
        }

        return new ContextWrapper(context);
    }

    @TargetApi(Build.VERSION_CODES.N)
    private static Configuration config(Configuration config, Locale newLocale){
        config.setLocale(newLocale);
        LocaleList localeList = new LocaleList(newLocale);
        LocaleList.setDefault(localeList);
        config.setLocales(localeList);

        return config;
    }


    @SuppressWarnings("deprecation")
    public static void forceLocale(Context context, String localeCode) {
        String localeCodeLowerCase = localeCode.toLowerCase();

        Resources resources = context.getApplicationContext().getResources();
        Configuration overrideConfiguration = resources.getConfiguration();
        Locale overrideLocale = new Locale(localeCodeLowerCase);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            overrideConfiguration.setLocale(overrideLocale);
        } else {
            overrideConfiguration.locale = overrideLocale;
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            context.getApplicationContext().createConfigurationContext(overrideConfiguration);
        } else {
            resources.updateConfiguration(overrideConfiguration, null);
        }
    }
}
