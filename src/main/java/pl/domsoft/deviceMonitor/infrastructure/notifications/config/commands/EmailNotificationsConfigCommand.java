package pl.domsoft.deviceMonitor.infrastructure.notifications.config.commands;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import pl.domsoft.deviceMonitor.infrastructure.base.interfaces.CommandHandler;
import pl.domsoft.deviceMonitor.infrastructure.notifications.config.entities.NotificationSendTime;
import pl.domsoft.deviceMonitor.infrastructure.notifications.config.entities.email.EmailNotificationConfig;
import pl.domsoft.deviceMonitor.infrastructure.notifications.config.entities.email.EmailTarget;
import pl.domsoft.deviceMonitor.infrastructure.notifications.config.entities.sms.SMSNotificationConfig;
import pl.domsoft.deviceMonitor.infrastructure.notifications.config.entities.sms.SMSTarget;
import pl.domsoft.deviceMonitor.infrastructure.notifications.config.handlers.interfaces.EmailNotificationConfigHandler;
import pl.domsoft.deviceMonitor.infrastructure.notifications.config.model.EmailTargetModel;
import pl.domsoft.deviceMonitor.infrastructure.notifications.config.model.NotificationSendTimeModel;
import pl.domsoft.deviceMonitor.infrastructure.notifications.config.model.SMSTargetModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Model widoku konfiguracji powiadomien email
 * przechowuje informacje kiedy na jakie numery/emaile i jakie powiadomienia mając być
 * wysyłane
 * Created by szymo on 21.08.2017.
 */
public class EmailNotificationsConfigCommand extends BaseNotificationsConfigCommand<EmailTargetModel, EmailNotificationConfig> {

    @JsonCreator
    public EmailNotificationsConfigCommand(
            @JsonProperty("sendNotificationsHours") List<NotificationSendTimeModel> sendNotificationsHours,
            @JsonProperty("targets")  List<EmailTargetModel> targets
    ){
        super(sendNotificationsHours, targets);
    }

    public EmailNotificationsConfigCommand(EmailNotificationConfig emailNotificationConfig) {
        super(convertHourTime(emailNotificationConfig.getNotificationSendTimes()), convertTargets(emailNotificationConfig.getEmailTargets()));
    }

    private static List<EmailTargetModel> convertTargets(List<EmailTarget> smsTargets) {
        List<EmailTargetModel> targetModels = new ArrayList<>(smsTargets.size());
        for (EmailTarget target: smsTargets) {
            targetModels.add(new EmailTargetModel(target));
        }

        return targetModels;
    }

    @JsonIgnore
    @Override
    public Class<? extends CommandHandler> getHandlerClass() {
        return EmailNotificationConfigHandler.class;
    }

    @JsonIgnore
    @Override
    public boolean isLoggable() {
        return true;
    }

    @Override
    public EmailNotificationConfig toEntity() {
        return new EmailNotificationConfig(this);
    }
}
