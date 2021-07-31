package com.example.language3605;

public class Badge {
        private String name;
        private boolean achieved;
        private String image;

        public Badge(){

        }

        public Badge(String name, boolean achieved, String image) {
            this.name = name;
            this.achieved = achieved;
            this.image = image;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isAchieved() {
            return achieved;
        }

        public void setAchieved(boolean achieved) {
            this.achieved = achieved;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }

