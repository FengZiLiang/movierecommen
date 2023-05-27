<template>
  <div class="movieSetBG">
    <el-container style="background: rgba(109,114,120,0.1);margin:20px 20px">
        <el-main v-if="categoryView">
          <movies-view ref="movieView"></movies-view>
        </el-main>
        <el-main v-else>
          <movies-view ref="movieView"></movies-view>
        </el-main>
    </el-container>
  </div>
</template>

<script>
import MoviesView from '@/components/MoviesView'

export default {
  name: 'MovieSet',
  components: {MoviesView},
  data () {
    return {
      categoryView: true
    }
  },
  methods: {
    listByCategory () {
      this.categoryView = true
      const _this = this
      // const cid = _this.$refs.categories.cid
      // const dateOrRate = _this.$refs.categories.dateOrRate
      // const url = 'movies/category/' + cid + '/' + dateOrRate
      const url = '/movie/10movies'
      _this.$axios.get(url).then(resp => {
        this.$alert(resp)
        if (resp && resp.status === 200) {
          this.$refs.movieView.movies = resp.data
        }
      })
    }
  }
}
</script>

<style scoped>

</style>
