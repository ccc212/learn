<!-- <template>
  <div class="file-management">
    <el-header>
      <el-avatar :src="avatarUrl" @click="handleAvatarClick" class="avatar"></el-avatar>
    </el-header>
    <el-main>
      <el-upload
        class="upload-demo"
        action="/upload"
        :on-preview="handlePreview"
        :on-remove="handleRemove"
        :file-list="fileList"
        list-type="text">
        <el-button slot="trigger" type="primary">点击上传</el-button>
        <el-button type="success" class="upload-demo-delete" icon="el-icon-delete" circle></el-button>
      </el-upload>
      <el-table :data="fileList" style="width: 100%">
        <el-table-column prop="name" label="文件名" sortable></el-table-column>
        <el-table-column prop="size" label="大小" sortable></el-table-column>
        <el-table-column prop="date" label="上传时间" sortable></el-table-column>
        <el-table-column label="操作">
          <template slot-scope="scope">
            <el-button @click="handleDownload(scope.row)">下载</el-button>
          </template>
        </el-table-column>
      </el-table>
    </el-main>
    
  </div>
</template>

<script>
export default {
  data() {
    return {
      avatarUrl: '../assets/img/0.png',
      fileList: [
        { name: 'file1.txt', size: '100KB', date: '2024-03-10' },
        { name: 'file2.jpg', size: '200KB', date: '2024-03-11' },
        { name: 'file3.pdf', size: '300KB', date: '2024-03-12' }
      ]
    };
  },
  methods: {
    handleAvatarClick() {
      // 处理点击个人头像事件
    },
    handlePreview(file) {
      // 处理文件预览事件
    },
    handleRemove(file, fileList) {
      // 处理文件删除事件
    },
    handleDownload(file) {
      // 处理文件下载事件
    }
  }
};
</script>

<style>
.file-management {
  width: 800px;
  margin: 0 auto;
  position: relative;
  overflow: hidden;
  background-color: black;
}
.glass {
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  backdrop-filter: blur(100px); /* 毛玻璃效果 */
}
.avatar {
  float: right;
  margin-top: 15px;
}

  @import url('../lib/font-awesome-4.7.0/css/font-awesome.min.css');
  @import url('./index.css');
</style> -->
