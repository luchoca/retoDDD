//package UseCase.AggregatePista;
//
//
//public class RemovePistaUseCase extends UseCase<RequestCommand<RemovePista>, ResponseEvents> {
//    @Override
//    public void executeUseCase(RequestCommand<RemovePista> removeClientRequestCommand) {
//        var command = removeClientRequestCommand.getCommand();
//        Trainer trainer = Trainer.from(command.getTrainerID(), repository().getEventsBy(command.getTrainerID().value()));
//        trainer.removeClient(command.getClientID());
//        emit().onResponse(new ResponseEvents(trainer.getUncommittedChanges()));
//    }
//}

//
//public class RemoveClientUseCase extends UseCase<RequestCommand<RemoveClient>, ResponseEvents> {
//    @Override
//    public void executeUseCase(RequestCommand<RemoveClient> removeClientRequestCommand) {
//        var command = removeClientRequestCommand.getCommand();
//        Trainer trainer = Trainer.from(command.getTrainerID(), repository().getEventsBy(command.getTrainerID().value()));
//
//        trainer.removeClient(command.getClientID());
//        emit().onResponse(new ResponseEvents(trainer.getUncommittedChanges()));
//    }
//}