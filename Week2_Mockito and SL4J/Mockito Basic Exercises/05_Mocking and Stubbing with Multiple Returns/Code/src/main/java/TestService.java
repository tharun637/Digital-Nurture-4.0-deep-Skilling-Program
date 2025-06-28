public class TestService {
    ExternalApi api;
    public TestService(ExternalApi api) {
        this.api = api;
    }

    public String checkProgress() {
        return api.getStatus();
    }
}
