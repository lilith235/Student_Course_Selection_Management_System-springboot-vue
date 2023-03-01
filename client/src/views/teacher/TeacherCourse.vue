<template>
  <div class="course-wrap">
    <div class="crumbs">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item>
          <i class="el-icon-fa fa-book"></i> 授课查询
        </el-breadcrumb-item>
      </el-breadcrumb>
    </div>



    <el-dialog :visible.sync="editing" class="course-form" title="创建" width="30%">
      <el-form :model="entityForm" label-width="70px" ref="form">
        <el-form-item label="课程名">
          <el-input v-model="entityForm.name"></el-input>
        </el-form-item>
        <el-form-item label="授课教师">
          <el-input disabled v-model="entityForm.teacherName"></el-input>
        </el-form-item>
        <el-form-item label="年级">
          <el-input type="number" v-model="entityForm.grade"></el-input>
        </el-form-item>
        <el-form-item label="上课时间">
          <el-select v-model="courseDay">
            <el-option
                :key="index"
                :label="item"
                :value="index"
                v-for="(item, index) in days"
            >
            </el-option>
          </el-select>
          <el-select v-model="courseTime">
            <el-option
                :key="index"
                :label="item"
                :value="index"
                v-for="(item, index) in times"
            >
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="时长(节)">
          <el-input type="number" v-model="courseLength"></el-input>
        </el-form-item>
        <el-form-item label="上课地点">
          <el-input v-model="entityForm.location"></el-input>
        </el-form-item>
        <el-form-item label="学分">
          <el-input type="number" v-model="entityForm.credit"></el-input>
        </el-form-item>
        <el-form-item label="最大容量">
          <el-input type="number" v-model="entityForm.maxSize"></el-input>
        </el-form-item>

        <el-form-item label="课程简介">
          <el-input type="textarea"
                    :rows="3"
                    v-model="entityForm.introduction"></el-input>
        </el-form-item>

      </el-form>
      <span class="dialog-footer" slot="footer">
          <el-button @click="save" type="primary">确 定</el-button>
          <el-button @click="editing = false">取 消</el-button>
        </span>
    </el-dialog>

    <div class="container">
      <div class="query-form">
        <el-row :gutter="20">
          <el-col :span="2">
            <el-button @click="create" icon="el-icon-plus">创建</el-button>
          </el-col>
        </el-row>
      </div>

      <div class="table">
        <el-table
            :data="tableData"
            border
            height="390px" stripe>
          <el-table-column label="课程Id" prop="id" />
          <el-table-column label="课程名" prop="name" />
          <el-table-column label="年级" prop="grade" />
          <el-table-column label="学分" prop="credit" />
          <el-table-column label="上课时间" prop="time" />
          <el-table-column label="上课地点" prop="location" />
          <el-table-column label="选课人数" prop="selectedCount" />
        </el-table>
      </div>
    </div>
  </div>
</template>

<script>
import * as api from "../../api/teacher/course";
import * as api2 from "../../api/teacher/info";
let teachername;
export default {
  name: "TeacherCourse",
  data() {
    return {
      tableData: [],
      queryForm: {
        departmentName: "",
        teacherName: "",
        name: ""
      },
      entityForm: {},
      editing: false,
      teachers: [],
      courseDay: "",
      courseTime: "",
      courseLength: 0,

      days: [
        "星期一",
        "星期二",
        "星期三",
        "星期四",
        "星期五",
        "星期六",
        "星期日"
      ],
      times: [
        "第一节",
        "第二节",
        "第三节",
        "第四节",
        "第五节",
        "第六节",
        "第七节",
        "第八节",
        "第九节"
      ],

    };
  },
  methods: {
    getList() {
      api.list().then(res => {
        this.tableData = res;
      });
    },
    create() {

      this.entityForm = {
        id: -1,
        teacherName:teachername,
        teacherId:999,
        name:"",
        grade: 2020,
        time: "",
        location: "",
        credit: 2,
        maxSize: 50,
        introduction:""
      };
      this.courseDay = 1;
      this.courseTime = 1;
      this.courseLength = 2;
      this.editing = true;

    },


    save() {
      let day = this.courseDay + 1;
      let time = this.courseTime + 1;
      this.entityForm.time = day + "-" + time + "-" + this.courseLength;
      api.create(this.entityForm).then(() => {
        this.finishSave();
      });

    },


    finishSave(){
      this.$message.success("成功");
      this.getList();
      this.editing = false;
    }
  },

  created() {
    this.getList();
    api2.get().then(res => {
      teachername=res.name;
    });
  }
};
</script>

<style scoped>

</style>
