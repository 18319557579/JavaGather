package com.github.megatronking.stringfog;

import com.github.megatronking.stringfog.xor.StringFogImpl;
import com.hsf.javautils.regex.RegexRecord;

public final class StringFog {
    private static final StringFogImpl IMPL = new StringFogImpl();

    public static String decrypt(String paramString1, String paramString2) {
        byte[] arrayOfByte = Base64.decode(paramString1, 0);
        return IMPL.decrypt(arrayOfByte, Base64.decode(paramString2, 0));
    }

    public static void main(String[] args) {
        String result = StringFog.decrypt("xAKt0b3xoNvDBbTR/oey3NwDpviftb3L7EywwLeo/pWc\n", "sWzEpcTc07g=\n");
        System.err.println(result);

        result = StringFog.decrypt("8F4BA3UzO+7wXgAHaSI7\n", "gjt2YgdXXoo=\n");
        System.err.println(result);

        result =  StringFog.decrypt("8KZKqXFxpLrEtF2lQG6eovilQq9ARbW667R08Q==\n", "m9ErwC4awcM=\n");
        System.err.println(result);

        result =  StringFog.decrypt("TaT6Du78qqVDvPYK9eeoo1qr/Q==\n", "D+WpS7G46+w=\n");
        System.err.println(result);


        result =  StringFog.decrypt("Ug==\n", "cctwjsnXFXg=\n");
        System.err.println(result);

        result =  StringFog.decrypt("EfkCTPYybIwd\n", "RLBMCrltJ8k=\n");
        System.err.println(result);

        String originStr = "package com.dlew.lib;\n" +
                "\n" +
                "import android.app.Activity;\n" +
                "import android.app.Application;\n" +
                "import android.text.TextUtils;\n" +
                "import androidx.lifecycle.ViewModel;\n" +
                "import com.appsflyer.AppsFlyerLib;\n" +
                "import com.dlew.StringFog;\n" +
                "import com.dlew.common.SPUtil;\n" +
                "import com.dlew.common.ServerTimeUtil;\n" +
                "import com.dlew.events.DLEWglEvent;\n" +
                "import com.dlew.hardware.PhoneInfoWrapper;\n" +
                "import com.dlew.log.ActivityLifecycleManager;\n" +
                "import com.dlew.log.EventTrackManager;\n" +
                "import com.dlew.log.GGAnalysis;\n" +
                "import com.dlew.net.GameNet;\n" +
                "import com.dlew.net.StrategyNet;\n" +
                "import com.dlew.net.UMKNet;\n" +
                "import com.dlew.net.bean.DLEWABData;\n" +
                "import com.dlew.net.bean.DLEWABField;\n" +
                "import com.dlew.net.bean.DLEWSettingInfo;\n" +
                "import com.dlew.net.bean.DLEWUInfo;\n" +
                "import com.dlew.net.bean.DLEWULRsp;\n" +
                "import com.dlew.net.util.DLEWNetCallback;\n" +
                "import com.dlew.net.util.ThreadExecutorProxy;\n" +
                "import com.dlew.other.ad.DLEWAd;\n" +
                "import com.dlew.other.af.AFWrapper;\n" +
                "import com.dlew.other.af.DLEWGyData;\n" +
                "import com.dlew.other.fb.DLEWFBWrapper;\n" +
                "import com.elvishew.xlog.LogConfiguration;\n" +
                "import com.elvishew.xlog.XLog;\n" +
                "import com.google.gson.Gson;\n" +
                "import java.math.BigDecimal;\n" +
                "\n" +
                "/* loaded from: DLEWSDK_2.8.4.aar:classes.jar:com/dlew/lib/DLEWSDK.class */\n" +
                "public class DLEWSDK extends ViewModel {\n" +
                "    private static boolean _initCompleted;\n" +
                "    private static DLEWUInfo _uInfo;\n" +
                "    private static DLEWNetCallback<DLEWUInfo> _initCompletedCallback;\n" +
                "    private static double[] m_LTVThresholds;\n" +
                "    private static String m_adThrottle;\n" +
                "    private static String m_localValueConfig;\n" +
                "    private static String m_typeBiddingConfig;\n" +
                "    private static boolean m_trackThrottle;\n" +
                "    private static int _initTaskCompletedCount;\n" +
                "    private static Application application;\n" +
                "    private static Activity activity;\n" +
                "    public static final String USER_INFO_KEY = StringFog.decrypt(\"EfkCTPYybIwd\\n\", \"RLBMCrltJ8k=\\n\");\n" +
                "    static final String kLocalValueConfig = StringFog.decrypt(\"0sZQpDzHUcTrzHCqPvdZzw==\\n\", \"nqkzxVCRMKg=\\n\");\n" +
                "\n" +
                "    /* loaded from: DLEWSDK_2.8.4.aar:classes.jar:com/dlew/lib/DLEWSDK$EeleE.class */\n" +
                "    public class EeleE implements DLEWNetCallback<DLEWGyData> {\n" +
                "        @Override // com.dlew.net.util.DLEWNetCallback\n" +
                "        /* renamed from: EvLveE1, reason: merged with bridge method [inline-methods] */\n" +
                "        public void OnCompleted(boolean z, DLEWGyData dLEWGyData) {\n" +
                "        }\n" +
                "    }\n" +
                "\n" +
                "    /* loaded from: DLEWSDK_2.8.4.aar:classes.jar:com/dlew/lib/DLEWSDK$EvLeE11LLE.class */\n" +
                "    public class EvLeE11LLE implements DLEWNetCallback<DLEWABData[]> {\n" +
                "\n" +
                "        /* loaded from: DLEWSDK_2.8.4.aar:classes.jar:com/dlew/lib/DLEWSDK$EvLeE11LLE$EvLveE1.class */\n" +
                "        public class EvLveE1 implements Runnable {\n" +
                "            public EvLveE1() {\n" +
                "            }\n" +
                "\n" +
                "            @Override // java.lang.Runnable\n" +
                "            public void run() {\n" +
                "                DLEWSDK._initCompletedCallback.OnCompleted(true, DLEWSDK._uInfo);\n" +
                "                DLEWBus.post(new DLEWglEvent(DLEWglEvent.TYPE.ON_SDK_INITIALIZED));\n" +
                "            }\n" +
                "        }\n" +
                "\n" +
                "        @Override // com.dlew.net.util.DLEWNetCallback\n" +
                "        /* renamed from: EvLveE1, reason: merged with bridge method [inline-methods] */\n" +
                "        public void OnCompleted(boolean z, DLEWABData[] dLEWABDataArr) {\n" +
                "            if (z && dLEWABDataArr != null && dLEWABDataArr.length != 0) {\n" +
                "                for (DLEWABData dLEWABData : dLEWABDataArr) {\n" +
                "                    for (DLEWABField dLEWABField : dLEWABData.fields) {\n" +
                "                        if (dLEWABField.fkey.equals(StringFog.decrypt(\"XLKsJZmBgJBluIwrm7GImw==\\n\", \"EN3PRPXX4fw=\\n\"))) {\n" +
                "                            if (!TextUtils.isEmpty(dLEWABField.fvalue)) {\n" +
                "                                String unused = DLEWSDK.m_localValueConfig = dLEWABField.fvalue;\n" +
                "                                SPUtil.putString(StringFog.decrypt(\"UOoU8KAqJFBp4DT+ohosWw==\\n\", \"HIV3kcx8RTw=\\n\"), DLEWSDK.m_localValueConfig);\n" +
                "                                if (EventTrackManager.getInstance().strategyId.equals(StringFog.decrypt(\"Hg==\\n\", \"L+JYe3C33ns=\\n\"))) {\n" +
                "                                    EventTrackManager.getInstance().strategyId = dLEWABData.vid;\n" +
                "                                }\n" +
                "                            }\n" +
                "                        } else if (dLEWABField.fkey.equals(StringFog.decrypt(\"AMULRQXofkok/jF1\\n\", \"TJFdEW2aGzk=\\n\"))) {\n" +
                "                            double[] unused2 = DLEWSDK.m_LTVThresholds = (double[]) new Gson().fromJson(dLEWABField.fvalue, double[].class);\n" +
                "                        } else if (dLEWABField.fkey.equals(StringFog.decrypt(\"hGHgbVp9WrapQA==\\n\", \"xSW0BSgSLsI=\\n\"))) {\n" +
                "                            String unused3 = DLEWSDK.m_adThrottle = dLEWABField.fvalue;\n" +
                "                        } else if (dLEWABField.fkey.equals(StringFog.decrypt(\"ABplHutlOtw7HHAR5Q==\\n\", \"VGgEfYAxUq4=\\n\"))) {\n" +
                "                            if (dLEWABField.fvalue.equals(StringFog.decrypt(\"+w==\\n\", \"yme84eQFESE=\\n\"))) {\n" +
                "                                boolean unused4 = DLEWSDK.m_trackThrottle = true;\n" +
                "                            }\n" +
                "                        } else if (dLEWABField.fkey.equals(StringFog.decrypt(\"sApqMhGc57iNHX0=\\n\", \"5HMaV1P1g9w=\\n\"))) {\n" +
                "                            if (!TextUtils.isEmpty(dLEWABField.fvalue)) {\n" +
                "                                String unused5 = DLEWSDK.m_typeBiddingConfig = dLEWABField.fvalue;\n" +
                "                            }\n" +
                "                            if (EventTrackManager.getInstance().strategyId.equals(StringFog.decrypt(\"hQ==\\n\", \"tJRIAIOD1vA=\\n\"))) {\n" +
                "                                EventTrackManager.getInstance().strategyId = dLEWABData.vid;\n" +
                "                            }\n" +
                "                        }\n" +
                "                    }\n" +
                "                }\n" +
                "            }\n" +
                "            if (DLEWConfig.isEnableLocalValue()) {\n" +
                "                DLEWSDK.InitEva(true);\n" +
                "            } else {\n" +
                "                boolean unused6 = DLEWSDK._initCompleted = true;\n" +
                "                ThreadExecutorProxy.getInstance().runOnMainThread(new EvLveE1());\n" +
                "            }\n" +
                "            DLEWSDK.access$008();\n" +
                "            if (DLEWSDK._initTaskCompletedCount == 2) {\n" +
                "                DLEWAd.startThrottle(DLEWSDK.m_adThrottle, DLEWSDK.activity);\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "\n" +
                "    /* loaded from: DLEWSDK_2.8.4.aar:classes.jar:com/dlew/lib/DLEWSDK$EvLveE1.class */\n" +
                "    public class EvLveE1 implements DLEWNetCallback<Object> {\n" +
                "        @Override // com.dlew.net.util.DLEWNetCallback\n" +
                "        public void OnCompleted(boolean z, Object obj) {\n" +
                "            DLEWSDK.access$008();\n" +
                "            if (DLEWSDK._initTaskCompletedCount == 2) {\n" +
                "                DLEWAd.startThrottle(DLEWSDK.m_adThrottle, DLEWSDK.activity);\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "\n" +
                "    /* loaded from: DLEWSDK_2.8.4.aar:classes.jar:com/dlew/lib/DLEWSDK$LvL11LLEl.class */\n" +
                "    public class LvL11LLEl implements DLEWNetCallback<DLEWULRsp> {\n" +
                "        @Override // com.dlew.net.util.DLEWNetCallback\n" +
                "        /* renamed from: EvLveE1, reason: merged with bridge method [inline-methods] */\n" +
                "        public void OnCompleted(boolean z, DLEWULRsp dLEWULRsp) {\n" +
                "            if (z) {\n" +
                "                DLEWSDK._uInfo.uid = dLEWULRsp.uid;\n" +
                "                DLEWSDK._uInfo.huoyueDays = Double.valueOf(dLEWULRsp.more.get(StringFog.decrypt(\"aXQkTe7C4nNpbiM=\\n\", \"CBdQJJinvRc=\\n\")).toString()).intValue();\n" +
                "                DLEWSDK._uInfo.zhuceDays = Double.valueOf(dLEWULRsp.more.get(StringFog.decrypt(\"GuIIPjDiwww34w4uMA==\\n\", \"aIdvV0OWpn4=\\n\")).toString()).intValue();\n" +
                "                DLEWSDK._uInfo.createTimeStamp = new BigDecimal(dLEWULRsp.more.get(StringFog.decrypt(\"IbLfk1qxUZ4rrd8=\\n\", \"QsC68i7UDuo=\\n\")).toString()).longValue();\n" +
                "                DLEWSDK._uInfo.now = dLEWULRsp.now;\n" +
                "                DLEWSDK._uInfo.local = dLEWULRsp.local;\n" +
                "                DLEWSDK._uInfo.yaoqingma = dLEWULRsp.inviteC;\n" +
                "                ServerTimeUtil.setServerTime(DLEWSDK._uInfo.now);\n" +
                "                SPUtil.putObject(StringFog.decrypt(\"4AbvZMr0XbPs\\n\", \"tU+hIoWrFvY=\\n\"), DLEWSDK._uInfo);\n" +
                "                if (!SPUtil.getBoolean(StringFog.decrypt(\"v0DrXUUnBgCSQe1NRQw=\\n\", \"zSWMNDZTY3I=\\n\") + DLEWSDK._uInfo.zhuceDays, false)) {\n" +
                "                    GGAnalysis.afTrack(StringFog.decrypt(\"Oo1w/vA7/O4XjHbu8BA=\\n\", \"SOgXl4NPmZw=\\n\") + DLEWSDK._uInfo.zhuceDays, null);\n" +
                "                    SPUtil.putBoolean(StringFog.decrypt(\"P14uB2yb2V0SXygXbLA=\\n\", \"TTtJbh/vvC8=\\n\") + DLEWSDK._uInfo.zhuceDays, true);\n" +
                "                }\n" +
                "                if (!SPUtil.getBoolean(StringFog.decrypt(\"WoYAY1kReu1Jnwg=\\n\", \"L/ZsDDh1JYw=\\n\"), false)) {\n" +
                "                    UMKNet.getInstance().UploadAppsflyerID(AppsFlyerLib.getInstance().getAppsFlyerUID(DLEWSDK.getApplication()));\n" +
                "                }\n" +
                "            }\n" +
                "            DLEWSDK.FetchStrategy();\n" +
                "        }\n" +
                "    }\n" +
                "\n" +
                "    /* loaded from: DLEWSDK_2.8.4.aar:classes.jar:com/dlew/lib/DLEWSDK$evleeEelE.class */\n" +
                "    public class evleeEelE implements DLEWNetCallback<DLEWGyData> {\n" +
                "        @Override // com.dlew.net.util.DLEWNetCallback\n" +
                "        /* renamed from: EvLveE1, reason: merged with bridge method [inline-methods] */\n" +
                "        public void OnCompleted(boolean z, DLEWGyData dLEWGyData) {\n" +
                "            DLEWSDK.Login();\n" +
                "        }\n" +
                "    }\n" +
                "\n" +
                "    /* loaded from: DLEWSDK_2.8.4.aar:classes.jar:com/dlew/lib/DLEWSDK$v1vLvLE.class */\n" +
                "    public class v1vLvLE implements DLEWNetCallback<String> {\n" +
                "        @Override // com.dlew.net.util.DLEWNetCallback\n" +
                "        /* renamed from: EvLveE1, reason: merged with bridge method [inline-methods] */\n" +
                "        public void OnCompleted(boolean z, String str) {\n" +
                "            if (!PhoneInfoWrapper.getConversionData().IsUnknow()) {\n" +
                "                DLEWSDK.Login();\n" +
                "            }\n" +
                "            if (SPUtil.getBoolean(StringFog.decrypt(\"9JQieQoL7YLznjs=\\n\", \"st1wKl5UudA=\\n\"), false)) {\n" +
                "                return;\n" +
                "            }\n" +
                "            EventTrackManager.getInstance().SendAppOpen();\n" +
                "            EventTrackManager.getInstance().SendAppFront();\n" +
                "            SPUtil.putBoolean(StringFog.decrypt(\"4+Z7/fgBQJ3k7GI=\\n\", \"pa8prqxeFM8=\\n\"), true);\n" +
                "        }\n" +
                "    }\n" +
                "\n" +
                "    /* loaded from: DLEWSDK_2.8.4.aar:classes.jar:com/dlew/lib/DLEWSDK$vl1L.class */\n" +
                "    public class vl1L implements Runnable {\n" +
                "        @Override // java.lang.Runnable\n" +
                "        public void run() {\n" +
                "            DLEWSDK._initCompletedCallback.OnCompleted(true, DLEWSDK._uInfo);\n" +
                "        }\n" +
                "    }\n" +
                "\n" +
                "    /* loaded from: DLEWSDK_2.8.4.aar:classes.jar:com/dlew/lib/DLEWSDK$vv11e.class */\n" +
                "    public class vv11e implements DLEWNetCallback<DLEWSettingInfo[]> {\n" +
                "\n" +
                "        /* renamed from: EvLveE1, reason: collision with root package name */\n" +
                "        public final /* synthetic */ boolean f5EvLveE1;\n" +
                "\n" +
                "        /* loaded from: DLEWSDK_2.8.4.aar:classes.jar:com/dlew/lib/DLEWSDK$vv11e$EvLveE1.class */\n" +
                "        public class EvLveE1 implements Runnable {\n" +
                "            public EvLveE1() {\n" +
                "            }\n" +
                "\n" +
                "            @Override // java.lang.Runnable\n" +
                "            public void run() {\n" +
                "                DLEWSDK._initCompletedCallback.OnCompleted(true, DLEWSDK._uInfo);\n" +
                "            }\n" +
                "        }\n" +
                "\n" +
                "        /* loaded from: DLEWSDK_2.8.4.aar:classes.jar:com/dlew/lib/DLEWSDK$vv11e$v1vLvLE.class */\n" +
                "        public class v1vLvLE implements Runnable {\n" +
                "            public v1vLvLE() {\n" +
                "            }\n" +
                "\n" +
                "            @Override // java.lang.Runnable\n" +
                "            public void run() {\n" +
                "                DLEWSDK._initCompletedCallback.OnCompleted(true, DLEWSDK._uInfo);\n" +
                "            }\n" +
                "        }\n" +
                "\n" +
                "        public vv11e(boolean z) {\n" +
                "            this.f5EvLveE1 = z;\n" +
                "        }\n" +
                "\n" +
                "        @Override // com.dlew.net.util.DLEWNetCallback\n" +
                "        /* renamed from: EvLveE1, reason: merged with bridge method [inline-methods] */\n" +
                "        public void OnCompleted(boolean z, DLEWSettingInfo[] dLEWSettingInfoArr) {\n" +
                "            if (!z || dLEWSettingInfoArr == null || dLEWSettingInfoArr.length == 0) {\n" +
                "                boolean unused = DLEWSDK._initCompleted = true;\n" +
                "                if (this.f5EvLveE1) {\n" +
                "                    ThreadExecutorProxy.getInstance().runOnMainThread(new v1vLvLE());\n" +
                "                    return;\n" +
                "                }\n" +
                "                return;\n" +
                "            }\n" +
                "            for (DLEWSettingInfo dLEWSettingInfo : dLEWSettingInfoArr) {\n" +
                "                if (dLEWSettingInfo.code.equals(StringFog.decrypt(\"g7YfkYyrT/+6vD+fjptH9A==\\n\", \"z9l88OD9LpM=\\n\"))) {\n" +
                "                    SPUtil.putString(StringFog.decrypt(\"94UF+HBFrEDOjyX2cnWkSw==\\n\", \"u+pmmRwTzSw=\\n\"), dLEWSettingInfo.setting.toString());\n" +
                "                    boolean unused2 = DLEWSDK._initCompleted = true;\n" +
                "                    if (this.f5EvLveE1) {\n" +
                "                        ThreadExecutorProxy.getInstance().runOnMainThread(new EvLveE1());\n" +
                "                    }\n" +
                "                }\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "\n" +
                "    /* loaded from: DLEWSDK_2.8.4.aar:classes.jar:com/dlew/lib/DLEWSDK$vvlEEv1lv.class */\n" +
                "    public class vvlEEv1lv implements Runnable {\n" +
                "        @Override // java.lang.Runnable\n" +
                "        public void run() {\n" +
                "            DLEWSDK._initCompletedCallback.OnCompleted(true, DLEWSDK._uInfo);\n" +
                "        }\n" +
                "    }\n" +
                "\n" +
                "    public static boolean getInitCompleted() {\n" +
                "        return _initCompleted;\n" +
                "    }\n" +
                "\n" +
                "    public static DLEWUInfo getUserInfo() {\n" +
                "        if (_uInfo == null) {\n" +
                "            DLEWUInfo dLEWUInfo = (DLEWUInfo) SPUtil.getObject(USER_INFO_KEY, DLEWUInfo.class);\n" +
                "            _uInfo = dLEWUInfo;\n" +
                "            if (dLEWUInfo == null) {\n" +
                "                _uInfo = new DLEWUInfo();\n" +
                "            }\n" +
                "        }\n" +
                "        return _uInfo;\n" +
                "    }\n" +
                "\n" +
                "    public static double[] getLTVThresholds() {\n" +
                "        return m_LTVThresholds;\n" +
                "    }\n" +
                "\n" +
                "    public static String getTypeBiddingConfig() {\n" +
                "        return m_typeBiddingConfig;\n" +
                "    }\n" +
                "\n" +
                "    public static boolean isTrackThrottle() {\n" +
                "        return m_trackThrottle;\n" +
                "    }\n" +
                "\n" +
                "    public static Application getApplication() {\n" +
                "        return application;\n" +
                "    }\n" +
                "\n" +
                "    public static Activity getActivity() {\n" +
                "        return activity;\n" +
                "    }\n" +
                "\n" +
                "    public static void Init(Activity activity2, DLEWNetCallback<DLEWUInfo> dLEWNetCallback) {\n" +
                "        _initCompletedCallback = dLEWNetCallback;\n" +
                "        activity = activity2;\n" +
                "        _uInfo = new DLEWUInfo();\n" +
                "        InitAppsflyer(application);\n" +
                "        DLEWAd.init(activity, new EvLveE1());\n" +
                "        DLEWFBWrapper.init();\n" +
                "    }\n" +
                "\n" +
                "    private static void InitAppsflyer(Application application2) {\n" +
                "        PhoneInfoWrapper.Init(new v1vLvLE());\n" +
                "        if (PhoneInfoWrapper.getConversionData().IsUnknow()) {\n" +
                "            AFWrapper.getInstance().init(application, new evleeEelE());\n" +
                "        } else {\n" +
                "            AFWrapper.getInstance().init(application, new EeleE());\n" +
                "        }\n" +
                "    }\n" +
                "\n" +
                "    /* JADX INFO: Access modifiers changed from: private */\n" +
                "    public static void Login() {\n" +
                "        if (TextUtils.isEmpty(_uInfo.uid)) {\n" +
                "            UMKNet.getInstance().Login(new LvL11LLEl());\n" +
                "        }\n" +
                "    }\n" +
                "\n" +
                "    /* JADX INFO: Access modifiers changed from: private */\n" +
                "    public static void FetchStrategy() {\n" +
                "        StrategyNet.getInstance().Fetch(StringFog.decrypt(\"PfU8m4+Bo1QE/xyVjbGrX13OLZuAvJZQA/Urjo+y7nk1zjeIjKO2VBS2C4OTsoBRFf42lIQ=\\n\", \"cZpf+uPXwjg=\\n\"), new EvLeE11LLE());\n" +
                "    }\n" +
                "\n" +
                "    public static void InitEva(boolean z) {\n" +
                "        if (DLEWConfig.isForceLocalValueConfig()) {\n" +
                "            _initCompleted = true;\n" +
                "            if (z) {\n" +
                "                ThreadExecutorProxy.getInstance().runOnMainThread(new vvlEEv1lv());\n" +
                "                return;\n" +
                "            }\n" +
                "            return;\n" +
                "        }\n" +
                "        if (TextUtils.isEmpty(m_localValueConfig)) {\n" +
                "            GameNet.getInstance().FetchConfig(kLocalValueConfig, new vv11e(z));\n" +
                "            return;\n" +
                "        }\n" +
                "        _initCompleted = true;\n" +
                "        if (z) {\n" +
                "            ThreadExecutorProxy.getInstance().runOnMainThread(new vl1L());\n" +
                "        }\n" +
                "    }\n" +
                "\n" +
                "    public static void onApplicationCreate(Application application2) {\n" +
                "        application = application2;\n" +
                "        PhoneInfoWrapper.putContext(application2);\n" +
                "        XLog.init(new LogConfiguration.Builder().logLevel(DLEWConfig.isPrintLog() ? Integer.MIN_VALUE : Integer.MAX_VALUE).tag(StringFog.decrypt(\"Ckm+5XKizgEVRYI=\\n\", \"UQ7fiRPat1I=\\n\")).build());\n" +
                "        ActivityLifecycleManager.getInstance().onApplicationCreate(application2);\n" +
                "    }\n" +
                "\n" +
                "    public static void onApplicationTerminate(Application application2) {\n" +
                "        ActivityLifecycleManager.getInstance().onApplicationTerminate(application2);\n" +
                "    }\n" +
                "\n" +
                "    public static /* synthetic */ int access$008() {\n" +
                "        int i = _initTaskCompletedCount;\n" +
                "        _initTaskCompletedCount = i + 1;\n" +
                "        return i;\n" +
                "    }\n" +
                "}";
        System.out.println("原始的: \n" + originStr);
        System.out.println("最终的:\n" + RegexRecord.decodeStringFog(originStr));

    }
}
