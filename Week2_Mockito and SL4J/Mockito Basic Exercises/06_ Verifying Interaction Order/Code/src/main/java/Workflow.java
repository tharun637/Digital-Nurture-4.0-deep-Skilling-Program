public class Workflow {
    Service service;

    public Workflow(Service service) {
        this.service = service;
    }

    public void execute() {
        service.start();
        service.process();
        service.end();
    }
}

