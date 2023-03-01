<template>
  <div class="course-wrap">
    <div class="crumbs">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item>
          <i class="el-icon-fa fa-book"></i> 课程管理
        </el-breadcrumb-item>
      </el-breadcrumb>
    </div>

    <div class="container">
      <div class="query-form">
        <el-row :gutter="20">


        </el-row>
      </div>

      <el-row justify="center" type="flex">
        <el-pagination
          :current-page.sync="pageIndex"
          :page-size="pageSize"
          :total="pageSize * pageCount"
          @current-change="getPage"
          background
          layout="prev, pager, next"
        >
        </el-pagination>
      </el-row>

      <div class="table">
        <el-table
            :data="tableData"
            border
            height="430px"
            stripe>
          <el-table-column label="课程Id" prop="id" />
          <el-table-column label="课程名" prop="name" width="200px" />
          <el-table-column label="教师" prop="teacherName" />
          <el-table-column label="所属学院" prop="departmentName" />
          <el-table-column label="年级" prop="grade" />
          <el-table-column label="学分" prop="credit" />
          <el-table-column
            align="center"
            label="上课时间"
            prop="time"
            width="130px"
          />
          <el-table-column label="已选人数" prop="selectedCount" />
          <el-table-column label="最大容量" prop="maxSize" />
          <el-table-column align="center" label="操作" >
            <template slot-scope="scope">
              <el-button
                @click="deleteItem(scope.row.id)"
                size="mini"
                type="danger"
                >删除
              </el-button>
            </template>
          </el-table-column>
        </el-table>
      </div>


    </div>
  </div>
</template>

<script>
import * as api from "../../api/admin/course";


export default {
  name: "AdminCourse",
  data() {
    return {
      queryForm: {
        departmentName: "",
        teacherName: "",
        name: ""
      },
      tableData: [],
      pageSize: api.pageSize,
      pageCount: 1,
      pageIndex: 1,
      editing: false,
      teachers: [],
      courseDay: "",
      courseTime: "",
      courseLength: 0,
    };
  },
  methods: {
    query() {
      api
        .getPageCount(
          this.queryForm.departmentName,
          this.queryForm.teacherName,
          this.queryForm.name
        )
        .then(res => {
          this.pageCount = res;
          this.pageIndex = 1;
          this.getPage(1);
        });
    },
    getPage(pageIndex) {
      api
        .getPage(
          pageIndex,
          this.queryForm.departmentName,
          this.queryForm.teacherName,
          this.queryForm.name
        )
        .then(res => {
          this.tableData = res;
        });
    },
    deleteItem(id) {
      api.deleteItem(id).then(() => {
        this.$message.success("删除成功");
        this.getPage(this.pageIndex);
      });
    },

  },
  created() {
    this.query();
  }
};
</script>

<style scoped></style>
