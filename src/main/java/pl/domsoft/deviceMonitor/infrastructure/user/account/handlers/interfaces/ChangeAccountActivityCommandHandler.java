package pl.domsoft.deviceMonitor.infrastructure.user.account.handlers.interfaces;

import pl.domsoft.deviceMonitor.infrastructure.base.interfaces.CommandHandler;
import pl.domsoft.deviceMonitor.infrastructure.user.account.commands.ChangeAccountActivityCommand;
import pl.domsoft.deviceMonitor.infrastructure.user.account.commands.EditAccountCommand;

/**
 * Created by szymo on 11.06.2017.
 */
public interface ChangeAccountActivityCommandHandler extends CommandHandler<ChangeAccountActivityCommand, Void> {
}
