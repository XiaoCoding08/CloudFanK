<template>
    <el-button text @click= "addtextquestion" >
      增加题目  {{ a2.value }}
    </el-button>
    <!-- 弹框 -->
    <el-dialog
      v-model="dialogVisible"
      title="增加题目"
      width="80%"
    >
    <el-form :model="form" >
    <el-form-item>
      <el-input
            placeholder="输入试题序号" v-model="form.indexs"
          />
    </el-form-item>
    <el-form-item>
      <el-input
            placeholder="输入题目ID" v-model="form.questionId"
          />
      <!-- <el-button type="primary">选择题目</el-button> -->
       <!-- 选择题目的列表 -->
       <el-table :data="tableData2" style="width: 100%; height: 70%;">
    <el-table-column label="题目id" width="250">
      <template #default="scope">
        <el-popover effect="light" trigger="hover" placement="top" width="auto">
          <template #default>
            <div>id: {{ scope.row.id }}</div>
           
          </template>
          <template #reference>
            <el-tag>{{ scope.row.id }}</el-tag>
          </template>
        </el-popover>
      </template>
    </el-table-column>
    <el-table-column label="题目内容" width="250">
      <template #default="scope">
        <el-popover effect="light" trigger="hover" placement="top" width="auto">
          <template #default>
            <div>context: {{ scope.row.context }}</div>
          </template>
          <template #reference>
            <el-tag>{{ scope.row.context }}</el-tag>
          </template>
        </el-popover>
      </template>
    </el-table-column>
    <el-table-column label="题目类型" width="250">
      <template #default="scope">
        <el-popover effect="light" trigger="hover" placement="top" width="auto">
          <template #default>
            <div>type: {{ scope.row.type }}</div>
          </template>
          <template #reference>
            <el-tag>{{ scope.row.type }}</el-tag>
          </template>
        </el-popover>
      </template>
    </el-table-column>
    <el-table-column label="Operations">
      <template #default="scope">
        <el-button size="small" @click="handleEdit(scope.$index, scope.row)"
          >选择</el-button
        >
      
      </template>
    </el-table-column>
  </el-table>
    </el-form-item>
    <el-form-item>
      <el-input
            placeholder="题目分数" v-model="form.scores"
          />
    </el-form-item>
    </el-form> 
      <template #footer>
        <span class="dialog-footer">
          <el-button @click="dialogVisible = false">取消</el-button>
          <el-button type="primary" @click="handlecreate">
            增加题目
          </el-button>
        </span>
      </template>
    </el-dialog>
    <!-- 数据列 -->
    <el-table :data="tableData" style="width: 200dvh; height: 80dvh;">
      <el-table-column label="试题号" width="250">
        <template #default="scope">
          <el-popover effect="light" trigger="hover" placement="top" width="auto">
            <template #default>
              <div>indexs  :   {{ scope.row.examQuestion.indexs}}</div>
             
            </template>
            <template #reference>
              <el-tag>{{ scope.row.examQuestion.indexs }}</el-tag>
            </template>
          </el-popover>
        </template>
      </el-table-column>
      <el-table-column label="试题内容" width="250">
        <template #default="scope">
          <el-popover effect="light" trigger="hover" placement="top" width="auto">
            <template #default>
              <div>context: {{ scope.row.question.context }}</div>
            </template>
            <template #reference>
              <el-tag>{{ scope.row.question.context }}</el-tag>
            </template>
          </el-popover>
        </template>
      </el-table-column>
      <el-table-column label="试题类型" width="250">
        <template #default="scope">
          <el-popover effect="light" trigger="hover" placement="top" width="auto">
            <template #default>
              <div>type: {{ scope.row.question.type }}</div>
            </template>
            <template #reference>
              <el-tag>{{ scope.row.question.type }}</el-tag>
            </template>
          </el-popover>
        </template>
      </el-table-column>
      <el-table-column label="分数" width="250">
        <template #default="scope">
          <el-popover effect="light" trigger="hover" placement="top" width="auto">
            <template #default>
              <div>scores  :   {{ scope.row.examQuestion.scores}}</div>
             
            </template>
            <template #reference>
              <el-tag>{{ scope.row.examQuestion.scores }}</el-tag>
            </template>
          </el-popover>
        </template>
      </el-table-column>
      <el-table-column label="Operations">
        <template #default="scope">
          <el-button size="small" @click="handleEdit(scope.$index, scope.row)"
            >修改</el-button
          >
          <el-button
            size="small"
            type="danger"
            @click="handleDelete(scope.$index, scope.row)"
            >删除</el-button
          >
        </template>
      </el-table-column>
    </el-table>
    <div>
      
    </div>
  </template>
  
  <script lang="ts" setup>
  
  import { ref , onMounted} from 'vue'
  import { ElMessageBox } from 'element-plus'
  import httpInstance from '../../utils/http';
  import { UploadFilled } from '@element-plus/icons-vue'
  import {useidStore,course_classinfoStore,classidStore,examidStore} from '@/stores/counter'
  import httpParams  from '@/utils/httpparam'
  const userid=ref(useidStore().id)
  const value1 = ref('')
  const value2 = ref('')
  const a1=course_classinfoStore()
  const a2=ref(a1.id)
  const classid=ref(classidStore().id)
  const examid=ref(examidStore().id)
  const dialogVisible = ref(false)
  const tableData=ref([])
  const tableData2=ref([])
  const radio = ref(0)
  const requestData2 = {
    teacherId:userid.value,
   
  };
  onMounted(() => { 
    httpParams.post('/teacher/getExamInfo', {
  
        examId:examid.value,
    
  })
    .then(response => {
      console.log(response.data);
      // 注册成功，可以根据实际需求进行处理，比如跳转到登录页面
      //alert(a2.value);
      dialogVisible.value=false;
      tableData.value= response.data.data
      
    })
    .catch(error => {
      console.log(error);
      // 注册失败，可以根据实际需求进行处理，比如显示错误提示
      alert(userid.value);
    });
    console.log( '班级id'+classid.value) })
  
  const form =ref 
  ({
   
    indexs:null ,
    questionId:null,
    scores:null,
  })
  const handlecreate = () =>{
  if(
     form.value.indexs=== null || 
     form.value.questionId===null||
     form.value.scores===null
  ){
    alert("信息没填完");
    return;
  }
    
  
  const requestData = {
   
   
    indexs:form.value.indexs,
    questionId:form.value.questionId,
    scores:form.value.scores,
    examId:examid.value,
  };
  
  
    httpInstance.post('/teacher/addExamQuestion', requestData)
    .then(response => {
      console.log(response.data);
      // 注册成功，可以根据实际需求进行处理，比如跳转到登录页面
       alert("创建成功");
      dialogVisible.value=false;
      
     
    })
    .catch(error => {
      console.log(error);
      // 注册失败，可以根据实际需求进行处理，比如显示错误提示
      alert("创建失败，请重新创建");
    });
   
  
  };

  const addtextquestion =()=>{
    httpParams.get('/teacher/queryAllQuestion', { params:{teacherId :userid.value}})
    .then(response => {
      console.log(response.data);
      // 注册成功，可以根据实际需求进行处理，比如跳转到登录页面
      // alert("创建成功");
      dialogVisible.value=true;
      tableData2.value=response.data.data
     
    })
    .catch(error => {
      console.log(error);
      // 注册失败，可以根据实际需求进行处理，比如显示错误提示
      alert("创建失败，请重新创建");
    });
  }
  const input=ref()
  interface User {
    id:0,
    context: '',
    type: '',
    scores:0,
   
  }
  
  const handleEdit = (index: number, row: User) => {
    console.log(index, row)
    const classData = {
    id: row.id,
   
  };
  
    form.value.questionId=row.id
     
    
  }
  
  
  const handleDelete = (index: number, row: User) => {
    console.log(index, row)
    const delectrequestData = {
    id: row.id,
   
  };
  httpParams.post('/teacher/delOneClass',
  {
    id:delectrequestData.id
  })
    .then(response => {
      console.log(response.data);
      // 注册成功，可以根据实际需求进行处理，比如跳转到登录页面
      alert("删除成功");
     
     
    })
    .catch(error => {
      console.log(error);
      // 注册失败，可以根据实际需求进行处理，比如显示错误提示
      alert("删除失败，请重试");
    });
  
  }
  
  

    
  
  
  </script>
  <style lang="scss" scoped>
  .app-container {
    
   
    position: fixed;
  
    
  }
  .demo-datetime-picker {
    display: flex;
    width: 100%;
    padding: 0;
    flex-wrap: wrap;
    justify-content: space-around;
    align-items: stretch;
  }
  .demo-datetime-picker .block {
    padding: 30px 0;
    text-align: center;
  }
  .line {
    width: 1px;
    background-color: var(--el-border-color);
  }
  </style>
  