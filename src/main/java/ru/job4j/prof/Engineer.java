package ru.job4j.prof;

public class Engineer extends Profession {
        private String tool;

        public Engineer() {

        }

        public Engineer(String name, String surname, String education, int birthday, String tool) {
                super(name, surname, education, birthday);
                this.tool = tool;
        }

        public Development create(Project project) {
                return null;
        }

}
