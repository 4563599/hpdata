package cn.lyy.hp.utils;

import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;

import java.util.List;
import java.util.Map;

public class JpushUtil {
    /**
     * 推送通知：以广播形式推送给所有平台
     *
     * @return
     */
    public static PushPayload buildPushObject_all_alias_alert() {
        return PushPayload.newBuilder()
                .setPlatform(Platform.all())//推送平台 ：all代表全部 ,也可写具体的平台android或ios
                .setAudience(Audience.all())//推送目标：all表示以广播形式推送，所有用户都可接收到
                .setNotification(Notification.alert("滑坡提醒！"))//推送到通知栏的内容
                .setOptions(Options.newBuilder()
                        .setApnsProduction(true)//APNs是否为生产环境，false为开发环境
                        .setSendno(1)//推送编号
                        .setTimeToLive(86400)//指定本推送的离线保存时长(单位：秒)，如果不传此字段则默认保存一天，最多指定保留十天
                        .build())
                .build();
    }

    /**
     * 推送通知：根据alias推送给个人
     *
     * @param alias
     * @param notification_title
     * @param msg_title
     * @param extrasparam
     * @return
     */
    public static PushPayload buildPushObject_all_alias_alertWithTitle(String alias, String notification_title, String msg_title, Map<String, String> extrasparam) {
        String iosAlert = notification_title + ":" + msg_title;
        //需要最新sdk版本
//        IosAlert iosAlert = IosAlert.newBuilder().setTitleAndBody("title", "alert body").build();
        //IosAlert.newBuilder().setTitleAndBody(notification_title, null, msg_title).setActionLocKey("PLAY").build()
        return PushPayload.newBuilder()
                //推送平台
                .setPlatform(Platform.all())
                //推送目标：all、tag、tag_and、tag_not、alias、registration_id等
                .setAudience(Audience.alias(alias))
                //通知
                .setNotification(Notification.newBuilder()
                        .addPlatformNotification(AndroidNotification.newBuilder()//指定不同平台的推送内容
                                .setTitle(notification_title)//标题
                                .setAlert(msg_title)//内容
                                //透传，不会显示在通知栏。用户可以通过此字段来做一些定制需求，如特定的key传要指定跳转的页面（value）
                                //另一种方式： addExtra(key,value)
                                .addExtras(extrasparam)
                                .build())
                        .addPlatformNotification(IosNotification.newBuilder()
                                .setAlert(iosAlert)//传一个IosAlert对象，指定apns title、title、subtitle等
                                .incrBadge(1)//此项是指定此推送的badge自动加1
                                //.setSound("sound.caf")//设置声音
                                //透传，不会显示在通知栏。用户可以通过此字段来做一些定制需求，如特定的key传要指定跳转的页面（value）
                                //另一种方式： addExtra(key,value)
                                .addExtras(extrasparam)
                                .setContentAvailable(true)//是否可以在锁屏状态下接收
                                .build())
                        .build())
                //可选参数
                .setOptions(Options.newBuilder()
                        .setApnsProduction(true)//APNs是否为生产环境，false为开发环境
                        .setSendno(1)//推送编号
                        .setTimeToLive(86400)//指定本推送的离线保存时长(单位：秒)，如果不传此字段则默认保存一天，最多指定保留十天
                        .build())
                .build();
    }

    /**
     * 推送通知:根据alias同时推送给多个用户
     *
     * @param aliases
     * @param notification_title
     * @param msg_title
     * @param extrasparam
     * @return
     */
    public static PushPayload buildPushObject_all_aliases_alertWithTitle(List<String> aliases, String notification_title, String msg_title, Map<String, String> extrasparam) {
        String iosAlert = notification_title + ":" + msg_title;
        //需要最新sdk版本
//        IosAlert iosAlert = IosAlert.newBuilder().setTitleAndBody("title", "alert body").build();
        //IosAlert.newBuilder().setTitleAndBody(notification_title, null, msg_title).setActionLocKey("PLAY").build()
        return PushPayload.newBuilder()
                //推送平台
                .setPlatform(Platform.all())
                //推送目标：all、tag、tag_and、tag_not、alias、registration_id等
                .setAudience(Audience.all())
                //通知
                .setNotification(Notification.newBuilder()
                        .addPlatformNotification(AndroidNotification.newBuilder()//指定不同平台的推送内容
                                .setTitle(notification_title)//标题
                                .setAlert(msg_title)//内容
                                //透传，不会显示在通知栏。用户可以通过此字段来做一些定制需求，如特定的key传要指定跳转的页面（value）
                                //另一种方式： addExtra(key,value)
                               // .addExtras(extrasparam)
                                .build())
                        .addPlatformNotification(IosNotification.newBuilder()
                                .setAlert(iosAlert)//传一个IosAlert对象，指定apns title、title、subtitle等
                                .incrBadge(1)//此项是指定此推送的badge自动加1
                                //.setSound("sound.caf")//设置声音
                                //透传，不会显示在通知栏。用户可以通过此字段来做一些定制需求，如特定的key传要指定跳转的页面（value）
                                //另一种方式： addExtra(key,value)
                               // .addExtras(extrasparam)
                                .setContentAvailable(true)//是否可以在锁屏状态下接收
                                .build())
                        .build())
                //可选参数
                .setOptions(Options.newBuilder()
                        .setApnsProduction(true)//APNs是否为生产环境，false为开发环境
                        .setSendno(1)//推送编号
                        .setTimeToLive(86400)//指定本推送的离线保存时长(单位：秒)，如果不传此字段则默认保存一天，最多指定保留十天
                        .build())
                .build();
    }

    /**
     * 推送通知和自定义消息：根据alias推给个人
     *
     * @param alias
     * @param notification_title
     * @param msg_title
     * @param msg_content
     * @param extrasparam
     * @return
     */
    public static PushPayload buildPushObject_all_alias_alertAndmessage(String alias, String notification_title, String msg_title, String msg_content, Map<String, String> extrasparam) {
        String iosAlert = notification_title + ":" + msg_title;
        //IosAlert.newBuilder().setTitleAndBody(notification_title, null, msg_title).setActionLocKey("PLAY").build()

        return PushPayload.newBuilder()
                //推送平台
                .setPlatform(Platform.all())
                //推送目标：all、tag、tag_and、tag_not、alias、registration_id等
                .setAudience(Audience.alias(alias))
                //通知
                .setNotification(Notification.newBuilder()
                        .addPlatformNotification(AndroidNotification.newBuilder()//指定不同平台的推送内容
                                .setTitle(notification_title)//标题
                                .setAlert(msg_title)//内容
                                //透传，不会显示在通知栏。用户可以通过此字段来做一些定制需求，如特定的key传要指定跳转的页面（value）
                                //另一种方式： addExtra(key,value)
                                .addExtras(extrasparam)
                                .build())
                        .addPlatformNotification(IosNotification.newBuilder()
                                .setAlert(iosAlert)//传一个IosAlert对象，指定apns title、body、subtitle等
                                .incrBadge(1)//此项是指定此推送的badge自动加1
                                //.setSound("sound.caf")//设置声音
                                //透传，不会显示在通知栏。用户可以通过此字段来做一些定制需求，如特定的key传要指定跳转的页面（value）
                                //另一种方式： addExtra(key,value)
                                .addExtras(extrasparam)
                                //.setContentAvailable(true)//是否可以在锁屏状态下接收
                                .build())
                        .build())
                //自定义消息
                .setMessage(Message.newBuilder()
                        .setTitle(msg_title)//消息标题
                        .setMsgContent(msg_content)//消息内容本身
                        //.setContentType("json")//消息内容类型
                        .addExtras(extrasparam)//json格式的可选参数
                        .build())
                //可选参数
                .setOptions(Options.newBuilder()
                        .setApnsProduction(true)//APNs是否为生产环境，false为开发环境
                        .setSendno(1)//推送编号
                        .setTimeToLive(86400)//指定本推送的离线保存时长(单位：秒)，如果不传此字段则默认保存一天，最多指定保留十天
                        .build())
                .build();
    }

    /**
     * 推送自定义消息：根据alias推给个人
     *
     * @param alias
     * @param msg_title
     * @param msg_content
     * @param extrasparam
     * @return
     */
    public static PushPayload buildPushObject_all_alias_message(String alias, String msg_title, String msg_content, Map<String, String> extrasparam) {

        return PushPayload.newBuilder()
                //推送平台
                .setPlatform(Platform.all())
                //推送目标：all、tag、tag_and、tag_not、alias、registration_id等
                .setAudience(Audience.alias(alias))
                //自定义消息
                .setMessage(Message.newBuilder()
                        .setTitle(msg_title)//消息标题
                        .setMsgContent(msg_content)//消息内容本身
                        //.setContentType("json")//消息内容类型
                        .addExtras(extrasparam)//json格式的可选参数
                        .build())
                //可选参数
                .setOptions(Options.newBuilder()
                        .setApnsProduction(true)//APNs是否为生产环境，false为开发环境
                        .setSendno(1)//推送编号
                        .setTimeToLive(86400)//指定本推送的离线保存时长(单位：秒)，如果不传此字段则默认保存一天，最多指定保留十天
                        .build())
                .build();
    }

    /**
     * 推送通知：根据tag推送给个人
     *
     * @param tag
     * @param tag_add
     * @param notification_title
     * @param msg_title
     * @param extrasparam
     * @return
     */
    @SuppressWarnings("static-access")
    public static PushPayload buildPushObject_all_tag_alertWithTitle(String tag, String tag_and, String notification_title, String msg_title, Map<String, String> extrasparam) {
        String iosAlert = notification_title + ":" + msg_title;
        //需要最新sdk版本
//        IosAlert iosAlert = IosAlert.newBuilder().setTitleAndBody("title", "alert body").build();
        //IosAlert.newBuilder().setTitleAndBody(notification_title, null, msg_title).setActionLocKey("PLAY").build()
        return PushPayload.newBuilder()
                //推送平台
                .setPlatform(Platform.all())
                //推送目标：all、tag、tag_and、tag_not、alias、registration_id等
                .setAudience(Audience.tag(tag).tag_and(tag_and))
                //通知
                .setNotification(Notification.newBuilder()
                        .addPlatformNotification(AndroidNotification.newBuilder()//指定不同平台的推送内容
                                .setTitle(notification_title)//标题
                                .setAlert(msg_title)//内容
                                //透传，不会显示在通知栏。用户可以通过此字段来做一些定制需求，如特定的key传要指定跳转的页面（value）
                                //另一种方式： addExtra(key,value)
                                .addExtras(extrasparam)
                                .build())
                        .addPlatformNotification(IosNotification.newBuilder()
                                .setAlert(iosAlert)//传一个IosAlert对象，指定apns title、title、subtitle等
                                .incrBadge(1)//此项是指定此推送的badge自动加1
                                //.setSound("sound.caf")//设置声音
                                //透传，不会显示在通知栏。用户可以通过此字段来做一些定制需求，如特定的key传要指定跳转的页面（value）
                                //另一种方式： addExtra(key,value)
                                .addExtras(extrasparam)
                                //.setContentAvailable(true)//是否可以在锁屏状态下接收
                                .build())
                        .build())
                //可选参数
                .setOptions(Options.newBuilder()
                        .setApnsProduction(true)//APNs是否为生产环境，false为开发环境
                        .setSendno(1)//推送编号
                        .setTimeToLive(86400)//指定本推送的离线保存时长(单位：秒)，如果不传此字段则默认保存一天，最多指定保留十天
                        .build())
                .build();
    }

    /**
     * 推送通知和自定义消息：根据tag推给个人
     *
     * @param tag
     * @param tag_add
     * @param notification_title
     * @param msg_title
     * @param msg_content
     * @param extrasparam
     * @return
     */
    @SuppressWarnings("static-access")
    public static PushPayload buildPushObject_all_tag_alertAndmessage(String tag, String tag_and, String notification_title, String msg_title, String msg_content, Map<String, String> extrasparam) {
        String iosAlert = notification_title + ":" + msg_title;
        //IosAlert.newBuilder().setTitleAndBody(notification_title, null, msg_title).setActionLocKey("PLAY").build()

        return PushPayload.newBuilder()
                //推送平台
                .setPlatform(Platform.all())
                //推送目标：all、tag、tag_and、tag_not、alias、registration_id等
                .setAudience(Audience.tag(tag).tag_and(tag_and))
                //通知
                .setNotification(Notification.newBuilder()
                        .addPlatformNotification(AndroidNotification.newBuilder()//指定不同平台的推送内容
                                .setTitle(notification_title)//标题
                                .setAlert(msg_title)//内容
                                //透传，不会显示在通知栏。用户可以通过此字段来做一些定制需求，如特定的key传要指定跳转的页面（value）
                                //另一种方式： addExtra(key,value)
                                .addExtras(extrasparam)
                                .build())
                        .addPlatformNotification(IosNotification.newBuilder()
                                .setAlert(iosAlert)//传一个IosAlert对象，指定apns title、body、subtitle等
                                .incrBadge(1)//此项是指定此推送的badge自动加1
                                //.setSound("sound.caf")//设置声音
                                //透传，不会显示在通知栏。用户可以通过此字段来做一些定制需求，如特定的key传要指定跳转的页面（value）
                                //另一种方式： addExtra(key,value)
                                .addExtras(extrasparam)
                                //.setContentAvailable(true)//是否可以在锁屏状态下接收
                                .build())
                        .build())
                //自定义消息
                .setMessage(Message.newBuilder()
                        .setTitle(msg_title)//消息标题
                        .setMsgContent(msg_content)//消息内容本身
                        //.setContentType("json")//消息内容类型
                        .addExtras(extrasparam)//json格式的可选参数
                        .build())
                //可选参数
                .setOptions(Options.newBuilder()
                        .setApnsProduction(true)//APNs是否为生产环境，false为开发环境
                        .setSendno(1)//推送编号
                        .setTimeToLive(86400)//指定本推送的离线保存时长(单位：秒)，如果不传此字段则默认保存一天，最多指定保留十天
                        .build())
                .build();
    }

    /**
     * 推送自定义消息：根据tag推给个人
     *
     * @param tag
     * @param msg_title
     * @param msg_content
     * @param extrasparam
     * @return
     */
    public static PushPayload buildPushObject_all_tags_message(String[] tag, String msg_title, String msg_content, Map<String, String> extrasparam) {

        return PushPayload.newBuilder()
                //推送平台
                .setPlatform(Platform.all())
                //推送目标：all、tag、tag_and、tag_not、alias、registration_id等
                .setAudience(Audience.tag(tag))
                //自定义消息
                .setMessage(Message.newBuilder()
                        .setTitle(msg_title)//消息标题
                        .setMsgContent(msg_content)//消息内容本身
                        //.setContentType("json")//消息内容类型
                        .addExtras(extrasparam)//json格式的可选参数
                        .build())
                //可选参数
                .setOptions(Options.newBuilder()
                        .setApnsProduction(true)//APNs是否为生产环境，false为开发环境
                        .setSendno(1)//推送编号
                        .setTimeToLive(86400)//指定本推送的离线保存时长(单位：秒)，如果不传此字段则默认保存一天，最多指定保留十天
                        .build())
                .build();
    }
}
