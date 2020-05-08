package sample;
import java.io.*;
import java.util.*;

    public class PackageData implements Serializable {
        private String operationType;
        private Client client;
        private ArrayList<Client> clients;

        public PackageData(String operationType, Client client) {
            this.operationType = operationType;
            this.client = client;
        }

        public PackageData(String operationType) {
            this.operationType = operationType;
        }

        public PackageData(ArrayList<Client> clients) {
            this.clients = clients;
        }

        public String getOperationType() {
            return operationType;
        }

        public void setOperationType(String operationType) {
            this.operationType = operationType;
        }

        public Client getClient() {
            return client;
        }

        public void setClient(Client client) {
            this.client = client;
        }

        public ArrayList<Client> getClients() {
            return clients;
        }

        public void setClients(ArrayList<Client> clients) {
            this.clients = clients;
        }
    }
