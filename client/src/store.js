import Vue from "vue";
import Vuex from "vuex";
import SideItem from "./common/sideItem";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    status: {
      loggedIn: false,
      userId: -1,
      swnumber: "",
      userType: 0,
      permission: 0
    },
    sideBarItems: [],
    loading: false
  },
  mutations: {
    login(state, res) {
      state.status.loggedIn = res.loggedIn;
      state.status.userId = res.userId;
      state.status.swnumber = res.swnumber;
      state.status.userType = res.userType;
      state.status.permission = res.permission;

      let items = [];
      for (let i = 0; i < SideItem.items.length; i++) {
        let item = SideItem.items[i];
        if (
          item.userType === res.userType &&
          (item.permission & res.permission) === item.permission
        ) {
          items.push(item);
        }
      }
      state.sideBarItems = items;
    },
    logout(state) {
      state.status = {
        loggedIn: false,
        userId: -1,
        swnumber: "",
        userType: 0,
        permission: 0
      };
    }
  },
  actions: {},
  modules: {}
});
