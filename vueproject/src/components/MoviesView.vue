<template>
  <div>
    <el-row style="height: 100%;">
      <el-tooltip effect="dark" placement="right"
                  v-for="item in movies"
                  :key="item.movieid"
      >
        <h1 slot="content" style="font-size: 24px;margin-bottom: 6px;">{{item.moviename}}({{changeDate(item.releasetime)}})</h1>
        <div slot="content">
          <rate
              :grade=item.averating
          >
          </rate>
        </div>
        <p slot="content">主演：{{item.leadactors}}</p>
        <p slot="content">导演：{{item.director}}</p>
        <p slot="content">类型：{{item.typelist}}</p>
        <p slot="content">参与评分人数：{{item.numrating}}</p>
        <p slot="content" style="width: 300px" class="abstract">简介：{{item.description}}</p>
        <el-card style="background-color:transparent;border:none;width: 200px;margin-bottom: 10px;height: 300px;float: left;margin-right: 25px" class="movie"
                 bodyStyle="padding:10px" shadow="hover">
           <span> <ScoreMovie @selected="choiceScore" :list="Scores"/></span>
          <div class="cover">
            <img :src="item.picture" alt="海报">
          </div>
          <div class="title" style="padding-left: 10px;">
            <span style="color:blue;font-size:10px;" >{{item.moviename}}</span>
            <span class="rate" style="font-size: 15px;color: #f9ca05;margin-left: 5px;margin-top: 2px">{{item.averating}}</span>
            <!--
            <img src="../assets/ico/delete.png" style="width: 15px;height: 15px;padding-left: 5px;" class="el-icon-delete" @click="deleteMovie(item.id)" alt="delete"
            -->
          </div>
        </el-card>
      </el-tooltip>
    </el-row>
  </div>
</template>

<script>
import Rate from '@/components/Rate'
import ScoreMovie from '@/components/ScoreMovie'
export default {
  name: 'MoviesView',
  components: {Rate, ScoreMovie},
  data () {
    return {
      userScore: [],
      currentPage: 1,
      pageSize: 11,
      movies: [],
      Scores: [
        1,
        2,
        3,
        4,
        5
      ]
    }
  },
  mounted: function () {
    this.loadMovies()
  },
  methods: {
    loadMovies () {
      const _this = this
      this.$axios.get('/movie/10movies').then(resp => {
        console.log(resp)
        if (resp && resp.status === 200) {
          _this.movies = resp.data
        }
      })
    },
    handleCurrentChange: function (currentPage) {
      this.currentPage = currentPage
      console.log(this.currentPage)
    },
    changeDate (date1) {
      const date = new Date(date1)
      return date.getFullYear() + '-' + (date.getMonth() + 1) + '-' + date.getDate()
    },
    choiceScore: function (o) {
      console.log(o)
    },
    getMovieid (movieid) {
      console.log(movieid)
    }
  }
}
</script>

<style scoped>

  .cover {
    width: 115px;
    height: 172px;
    margin-bottom: 7px;
    overflow: hidden;
    cursor: pointer;
  }

  img {
    width: 115px;
    height: 172px;
    /*margin: 0 auto;*/
  }

  .title {
    font-size: 14px;
    display: flex;
    justify-content: center;
  }
  .abstract {
    display: block;
    line-height: 17px;
  }

  a {
    text-decoration: none;
    height: 50px;
  }

  a:link, a:visited, a:focus {
    color: #3377aa;
  }

  p {
    font-size: 15px;
    width: 320px;
  }

  /deep/ li.number.active{
    background: transparent !important;
  }

  /deep/ li.number {
    background: transparent !important;
  }

  /deep/ li.el-icon.more {
    background: transparent !important;
  }
  /deep/ button.btn-prev {
    background: transparent !important;
  }

  /deep/ button.btn-next {
    background: transparent !important;
  }

</style>
