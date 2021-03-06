package pl.domsoft.deviceMonitor.infrastructure.user.account.handlers.interfaces;

import pl.domsoft.deviceMonitor.infrastructure.base.interfaces.CommandHandler;
import pl.domsoft.deviceMonitor.infrastructure.user.account.commands.DeleteAccountCommand;

/**
 * Created by szymo on 11.06.2017.
 */
public interface DeleteAccountCommandHandler extends CommandHandler<DeleteAccountCommand, Void> {
}
