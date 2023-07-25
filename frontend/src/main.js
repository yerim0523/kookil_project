import { createApp } from "vue";
import App from "./App.vue";
import axios from "axios";
import moment from "moment";

const app = createApp(App);
app.config.globalProperties.$axios = axios;
app.use(moment);
app.mount("#app");
