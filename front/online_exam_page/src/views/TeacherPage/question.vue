<template>
  <el-button text @click="dialogVisible = true">
    增加题目  {{ a2.value }}
  </el-button>
  <!-- 弹框 -->
  <el-dialog
    v-model="dialogVisible"
    title="增加题目"
    width="80%"
    
  >
  <p>题目类型</p>
  <el-radio-group v-model="radio">
    
    <el-radio :label="0">选择题</el-radio>
    <el-radio :label="1">填空题</el-radio>
  
  </el-radio-group>
    <el-form :model="form" >
        <el-form-item>
          <p>输入题目</p>
          <el-input
              v-model="form.context"
              :autosize="{ minRows: 2, maxRows: 4 }"
              type="textarea"
              placeholder="Please input"
            />
        </el-form-item>
      
      </el-form>  
      <el-upload
    class="upload-demo"
    drag
    action= "http://39.101.78.10:8080/common/upload"
    multiple
    @success="handleSuccess"
  >
    <el-icon class="el-icon--upload"><upload-filled /></el-icon>
    <div class="el-upload__text">
      Drop file here or <em>click to upload</em>
    </div>
    <template #tip>
      <div class="el-upload__tip">
        jpg/png files with a size less than 500kb
      </div>
    </template>
  </el-upload>
  <el-form :model="form" >
        <el-form-item>
          <p>答案</p>
          <el-input
              v-model="form.answer"
              placeholder="Please input"
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
            <div>id: {{ scope.row.id }}</div>
           
          </template>
          <template #reference>
            <el-tag>{{ scope.row.id }}</el-tag>
          </template>
        </el-popover>
      </template>
    </el-table-column>
    <el-table-column label="试题内容" width="250">
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
    <el-table-column label="试题类型" width="250">
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
import {useidStore,course_classinfoStore,classidStore} from '@/stores/counter'
import httpParams  from '@/utils/httpparam'
const userid=ref(useidStore().id)
const value1 = ref('')
const value2 = ref('')
const a1=course_classinfoStore()
const a2=ref(a1.id)
const classid=ref(classidStore().id)
const dialogVisible = ref(false)
const tableData=ref([])
const radio = ref(0)
const requestData2 = {
  teacherId:userid.value,
 
};
onMounted(() => { 
  httpParams.get('/teacher/queryAllQuestion', {
  params: {
    teacherId:userid.value,
  }
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
  answer :'',
  context:'',
  imageUrl:'',
  type:''
})
const handlecreate = () =>{
if(form.value.answer ===''||
form.value.context===''
){
  alert("信息没填完");
  return;
}
  

const requestData = {
  answer:form.value.answer,
  context:form.value.context,
  courseId:a2.value,
  imageUrl:filepath.value,
  type:radio.value
};


  httpInstance.post('/teacher/addQuestion', requestData)
  .then(response => {
    console.log(response.data);
    // 注册成功，可以根据实际需求进行处理，比如跳转到登录页面
     alert("创建成功");
    dialogVisible.value=false;
    filepath.value = null
   
  })
  .catch(error => {
    console.log(error);
    // 注册失败，可以根据实际需求进行处理，比如显示错误提示
    alert("创建失败，请重新创建");
  });
 

};
const input=ref()
interface User {
  id:0,
  context: '',
  type: '',
 
}

const handleEdit = (index: number, row: User) => {
  console.log(index, row)
  const classData = {
  id: row.id,
 
};

    const cr_cl=course_classinfoStore();
    cr_cl.setid(classData.id);
    //window.location.href ='/teacher/classinformation';
   
  
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
const shortcuts = [
  {
    text: 'Last week',
    value: () => {
      const end = new Date()
      const start = new Date()
      start.setTime(start.getTime() - 3600 * 1000 * 24 * 7)
      return [start, end]
    },
  },
  {
    text: 'Last month',
    value: () => {
      const end = new Date()
      const start = new Date()
      start.setTime(start.getTime() - 3600 * 1000 * 24 * 30)
      return [start, end]
    },
  },
  {
    text: 'Last 3 months',
    value: () => {
      const end = new Date()
      const start = new Date()
      start.setTime(start.getTime() - 3600 * 1000 * 24 * 90)
      return [start, end]
    },
  },
]
const filepath = ref('')

const handleSuccess  = (response) => {
  filepath.value = response.data
  console.log('地址'+filepath.value);
  
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
