<template>
  <div>


    <div>
      <el-carousel :interval="4000" type="card" height="150px">
        <el-carousel-item v-for="item in imgList" :key="item.id">
          <img :src="item.idView" class="image">
        </el-carousel-item>
      </el-carousel>
    </div>

<!--不同的身份看到的帮助手册内容不同-->
    <div v-if="$store.state.status.userType===3">
      <el-collapse v-model="activeName" accordion>
        <el-collapse-item title="帮助手册" disabled></el-collapse-item>
        <el-collapse-item>
          <template slot="title">
            <div style="color: #4EACC3; font-size: larger"><i class="header-icon el-icon-notebook-1"></i>学院、专业及班级的管理</div>
          </template>
          <div style="margin-left: 40px"><i class="header-icon el-icon-info"></i>您可以对系统的学院、专业及班级进行新建、编辑和删除</div>
          <div style="margin-left: 40px"><i class="header-icon el-icon-info"></i>在学院管理界面系统会自动为您统计不同学院下的专业数与教师数。<span style="color: #85FFBD">请注意：</span>在进行删除操作时确保当前学院下的所有专业都已被清空，否则将无法进行删除操作</div>
          <div style="margin-left: 40px"><i class="header-icon el-icon-info"></i>在专业管理界面对专业进行操作。<span style="color: #85FFBD">请注意：</span>在进行删除操作时确保当前专业下的所有班级都已被清空，否则将无法进行删除操作</div>
          <div style="margin-left: 40px"><i class="header-icon el-icon-info"></i>在班级管理界面对班级进行操作。<span style="color: #85FFBD">请注意：</span>在进行删除操作时确保当前班级下的所有学生都已被清空，否则将无法进行删除操作</div>
        </el-collapse-item>

        <el-collapse-item>
          <template slot="title">
            <div style="color: #4EACC3; font-size: larger"><i class="header-icon el-icon-notebook-1"></i>教师管理</div>
          </template>
          <div style="margin-left: 40px"><i class="header-icon el-icon-info"></i>您可以对系统的教师进行新建、编辑和删除</div>
          <div style="margin-left: 40px"><i class="header-icon el-icon-info"></i>点击新建添加一位教师的信息。<span style="color: #85FFBD">请注意：</span>如果您没有为教师设置密码，系统将自动设置初始密码为“A12345678”</div>
          <div style="margin-left: 40px"><i class="header-icon el-icon-info"></i>点击删除将一位教师的信息删除。<span style="color: #85FFBD">请注意：</span>在进行删除操作时确保当前教师所设的所有课程都已被清空，否则将无法进行删除操作</div>
        </el-collapse-item>

        <el-collapse-item>
          <template slot="title">
            <div style="color: #4EACC3; font-size: larger"><i class="header-icon el-icon-notebook-1"></i>学生管理</div>
          </template>
          <div style="margin-left: 40px"><i class="header-icon el-icon-info"></i>您可以对系统的学生进行新建、编辑和删除</div>
          <div style="margin-left: 40px"><i class="header-icon el-icon-info"></i>点击新建添加一位学生的信息。<span style="color: #85FFBD">请注意：</span>如果您没有为学生设置密码，系统将自动设置初始密码为“A12345678”</div>
          <div style="margin-left: 40px"><i class="header-icon el-icon-info"></i>点击删除将一位学生的信息删除。<span style="color: #85FFBD">请注意：</span>在进行删除操作时确保当前学生所选的所有课程都已被退选，否则将无法进行删除操作</div>
        </el-collapse-item>

        <el-collapse-item>
          <template slot="title">
            <div style="color: #4EACC3; font-size: larger"><i class="header-icon el-icon-notebook-1"></i>课程管理</div>
          </template>
          <div style="margin-left: 40px"><i class="header-icon el-icon-info"></i>您可以对所有课程进行查看和删除</div>
          <div style="margin-left: 40px"><i class="header-icon el-icon-info"></i>当一位教师创建新的课程后，该课程的详细信息将会出现在课程管理的列表中</div>
          <div style="margin-left: 40px"><i class="header-icon el-icon-info"></i>点击删除将一门已创建的课程删除。<span style="color: #85FFBD">请注意：</span>在进行删除操作时确保选择当前课程的所有学生都已退选，否则将无法进行删除操作</div>
        </el-collapse-item>
      </el-collapse>
    </div>

    <div v-if="$store.state.status.userType===2">
      <el-collapse v-model="activeName" accordion>
        <el-collapse-item title="帮助手册" disabled></el-collapse-item>
        <el-collapse-item>
          <template slot="title">
            <div style="color: #4EACC3; font-size: larger"><i class="header-icon el-icon-notebook-1"></i>授课查询</div>
          </template>
          <div style="margin-left: 40px"><i class="header-icon el-icon-info"></i>在此界面您可以查看自己所开设的所有课程以及选课人数</div>
          <div style="margin-left: 40px"><i class="header-icon el-icon-info"></i>点击创建添加一门新的课程。<span style="color: #85FFBD">请注意：</span>课程一旦创建将无法更改，请详细核查信息后再点击确定</div>
          <div style="margin-left: 40px"><i class="header-icon el-icon-info"></i>根据实际需要，系统允许您创建上课时间相同的不同课程</div>
          <div style="margin-left: 40px"><i class="header-icon el-icon-info"></i>如需删除课程请联系管理员进行操作</div>
        </el-collapse-item>

        <el-collapse-item>
          <template slot="title">
            <div style="color: #4EACC3; font-size: larger"><i class="header-icon el-icon-notebook-1"></i>教师课表</div>
          </template>
          <div style="margin-left: 40px"><i class="header-icon el-icon-info"></i>在此界面您可以查看自己所授课程的可视化课表</div>
          <div style="margin-left: 40px"><i class="header-icon el-icon-info"></i><span style="color: #85FFBD">请注意：</span>当两门课程的上课时间相同时，课表显示的是您最后创建的课程，这并不代表您同时间的其他课程未在系统中，只是没有显示</div>
        </el-collapse-item>

        <el-collapse-item>
          <template slot="title">
            <div style="color: #4EACC3; font-size: larger"><i class="header-icon el-icon-notebook-1"></i>成绩录入</div>
          </template>
          <div style="margin-left: 40px"><i class="header-icon el-icon-info"></i>在此界面您可以对选课学生的成绩进行录入</div>
          <div style="margin-left: 40px"><i class="header-icon el-icon-info"></i>您可以通过搜索框查看同一课程的不同学生或同一学生的不同课程，使您的操作更加便捷</div>
          <div style="margin-left: 40px"><i class="header-icon el-icon-info"></i><span style="color: #85FFBD">请注意：</span>平时分与笔试分只是便于学生查看与参考，系统并不会自动生成最终成绩，您可以根据课程的需要按不同权重录入最终成绩</div>
        </el-collapse-item>

        <el-collapse-item>
          <template slot="title">
            <div style="color: #4EACC3; font-size: larger"><i class="header-icon el-icon-notebook-1"></i>信息维护</div>
          </template>
          <div style="margin-left: 40px"><i class="header-icon el-icon-info"></i>在此界面您可以对自己的个人信息进行修改</div>
          <div style="margin-left: 40px"><i class="header-icon el-icon-info"></i><span style="color: #85FFBD">请注意：</span>工号、姓名与学院如需修改，请联系管理员操作</div>
          <div style="margin-left: 40px"><i class="header-icon el-icon-info"></i>您也可以通过输入新的密码以修改密码</div>
        </el-collapse-item>
      </el-collapse>
    </div>

    <div v-if="$store.state.status.userType===1">
      <el-collapse v-model="activeName" accordion>
        <el-collapse-item title="帮助手册" disabled></el-collapse-item>
        <el-collapse-item>
          <template slot="title">
            <div style="color: #4EACC3; font-size: larger"><i class="header-icon el-icon-notebook-1"></i>进入选课</div>
          </template>
          <div style="margin-left: 40px"><i class="header-icon el-icon-info"></i>在此界面您可以查看学院为您的年级开设的所有课程，但您已经选择的课程将不会出现在这里</div>
          <div style="margin-left: 40px"><i class="header-icon el-icon-info"></i>通过搜索可以根据课程名或者开课教师检索您想查找的课程，使您的操作更加便捷</div>
          <div style="margin-left: 40px"><i class="header-icon el-icon-info"></i>点击课程后的选课按钮可以选课。<span style="color: #85FFBD">请注意：</span>您在每日的同一时段至多选择一门课程，课程时间冲突将导致选课失败</div>
        </el-collapse-item>

        <el-collapse-item>
          <template slot="title">
            <div style="color: #4EACC3; font-size: larger"><i class="header-icon el-icon-notebook-1"></i>已选课程</div>
          </template>
          <div style="margin-left: 40px"><i class="header-icon el-icon-info"></i>在此界面您可以查看自己的所有选课</div>
          <div style="margin-left: 40px"><i class="header-icon el-icon-info"></i>点击退选进行课程退选操作。<span style="color: #85FFBD">请注意：</span>授课教师已经录入成绩的课程无法被退选</div>
        </el-collapse-item>

        <el-collapse-item>
          <template slot="title">
            <div style="color: #4EACC3; font-size: larger"><i class="header-icon el-icon-notebook-1"></i>信息维护</div>
          </template>
          <div style="margin-left: 40px"><i class="header-icon el-icon-info"></i>在此界面您可以对自己的个人信息进行修改</div>
          <div style="margin-left: 40px"><i class="header-icon el-icon-info"></i><span style="color: #85FFBD">请注意：</span>学号、姓名、学院、专业和班级如需修改，请联系管理员操作</div>
          <div style="margin-left: 40px"><i class="header-icon el-icon-info"></i>您也可以通过输入新的密码以修改密码</div>
        </el-collapse-item>

        <el-collapse-item>
          <template slot="title">
            <div style="color: #4EACC3; font-size: larger"><i class="header-icon el-icon-notebook-1"></i>其他</div>
          </template>
          <div style="margin-left: 40px"><i class="header-icon el-icon-info"></i>在查看课表界面您可以查看自己所修课程的可视化课表：包括课程名称、授课教师以及上课地点</div>
          <div style="margin-left: 40px"><i class="header-icon el-icon-info"></i>在成绩查询界面您可以查看自己所修课程的成绩，包括平时分、笔试分和最终成绩。<span style="color: #85FFBD">请注意：</span>如果成绩未显示，则说明教师还未录入成绩</div>
        </el-collapse-item>
      </el-collapse>
    </div>


  </div>

</template>

<script>
// import * as api from "../api/news";

export default {
  name: "Home",
  data() {
    return {
      activeName: '1',
      imgList: [
        { id: 0, idView: require("../assets/demo0.jpg") },
        { id: 1, idView: require("../assets/demo1.jpg") },
        { id: 2, idView: require("../assets/demo2.jpg") },
        { id: 3, idView: require("../assets/demo3.jpg") },
        { id: 4, idView: require("../assets/demo4.jpg") }
      ],
      screenWidth:0
    }
  },
  methods:{
    setSize:function () {
      // 通过浏览器宽度(图片宽度)计算高度
      this.bannerHeight = 400 / 1920 * this.screenWidth;
    },
  },
  mounted() {
    // 首次加载时,需要调用一次
    this.screenWidth =  window.innerWidth;
    this.setSize();
    // 窗口大小发生改变时,调用一次
    window.onresize = () =>{
      this.screenWidth =  window.innerWidth;
      this.setSize();
    }
  }
};
</script>

<style scoped>

.el-carousel__item h3 {
  color: #475669;
  font-size: 14px;
  opacity: 0.75;
  line-height: 200px;
  margin: 0;
}

.el-carousel__item h3 {
  color: #475669;
  font-size: 14px;
  opacity: 0.75;
  line-height: 200px;
  margin: 0;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n+1) {
  background-color: #d3dce6;
}
img{
  /*设置图片宽度和浏览器宽度一致*/
  width:100%;
  height:inherit;
}
</style>
