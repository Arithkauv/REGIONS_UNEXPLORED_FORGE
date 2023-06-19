package net.regions_unexplored.world.level.feature.tree;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.data.tags.RuTags;
import net.regions_unexplored.world.level.block.plant.other.BranchBlock;
import net.regions_unexplored.world.level.block.plant.other.SpanishMossBlock;
import net.regions_unexplored.world.level.feature.configuration.RuTreeConfiguration;

import java.util.Random;

public class GiantCypressTreeFeature extends Feature<RuTreeConfiguration> {

    public GiantCypressTreeFeature(Codec<RuTreeConfiguration> codec) {
        super(codec);
    }

    public boolean place(FeaturePlaceContext<RuTreeConfiguration> context) {
        RuTreeConfiguration treeConfiguration = context.config();
        BlockPos pos = context.origin();
        RandomSource randomSource = context.random();
        WorldGenLevel level = context.level();
        boolean hasVines = false;
        if(randomSource.nextInt(3)==0){
            hasVines = true;
        }
        int height_main = context.random().nextInt(treeConfiguration.sizeVariation) + treeConfiguration.minimumSize;
        int height_1n = context.random().nextInt(5) + 8;
        int height_1s = context.random().nextInt(5) + 8;
        int height_1e = context.random().nextInt(5) + 8;
        int height_1w = context.random().nextInt(5) + 8;
        int height_2n = context.random().nextInt(3) + 3;
        int height_2s = context.random().nextInt(3) + 3;
        int height_2e = context.random().nextInt(3) + 3;
        int height_2w = context.random().nextInt(3) + 3;
        int height_3n = context.random().nextInt(1) + 1;
        int height_3s = context.random().nextInt(1) + 1;
        int height_3e = context.random().nextInt(1) + 1;
        int height_3w = context.random().nextInt(1) + 1;

        int check = 0;
        BlockPos.MutableBlockPos checkPos = pos.mutable();
        while (check <= height_main) {
            if(!checkReplaceable(level, checkPos)){
                return false;
            }
            else{
                checkPos.move(Direction.UP);
                check = check + 1;
            }
        }
        int placeCheck = 0;
        BlockPos.MutableBlockPos placePos = pos.mutable();
        while (placeCheck <= height_main) {
            if (isReplaceableDirt(level, placePos) || level.getBlockState(placePos).canBeReplaced()||level.getBlockState(placePos).is(RuTags.BRANCHES)||level.getBlockState(placePos).is(BlockTags.LEAVES)) {
                placeLog(level, placePos, randomSource, treeConfiguration, Direction.Axis.Y);
                if(placeCheck==0){
                    placeRoot(level, placePos.below(), randomSource, treeConfiguration);
                }
                if(placeCheck==height_main){
                    placeTop(level,placePos,randomSource,treeConfiguration, hasVines);
                }
                if (placeCheck <= height_1n) {
                    placeLog(level, placePos.north(), randomSource, treeConfiguration, Direction.Axis.Y);
                        if(placeCheck==0){
                            placeRoot(level, placePos.below().north(), randomSource, treeConfiguration);
                        }
                        if(placeCheck==height_1n){
                            placeMoss(level, placePos.north());
                        }
                }
                if (placeCheck <= height_1s) {
                    placeLog(level, placePos.south(), randomSource, treeConfiguration, Direction.Axis.Y);
                        if(placeCheck==0){
                            placeRoot(level, placePos.below().south(), randomSource, treeConfiguration);
                        }
                        if(placeCheck==height_1s){
                            placeMoss(level, placePos.south());
                        }
                }
                if (placeCheck <= height_1e) {
                    placeLog(level, placePos.east(), randomSource, treeConfiguration, Direction.Axis.Y);
                        if(placeCheck==0){
                            placeRoot(level, placePos.below().east(), randomSource, treeConfiguration);
                        }
                        if(placeCheck==height_1e){
                            placeMoss(level, placePos.east());
                        }
                }
                if (placeCheck <= height_1w) {
                    placeLog(level, placePos.west(), randomSource, treeConfiguration, Direction.Axis.Y);
                        if(placeCheck==0){
                            placeRoot(level, placePos.below().west(), randomSource, treeConfiguration);
                        }
                        if(placeCheck==height_1w){
                            placeMoss(level, placePos.west());
                        }
                }
                if (placeCheck <= height_2n) {
                    placeLog(level, placePos.north().west(), randomSource, treeConfiguration, Direction.Axis.Y);
                        if(placeCheck==0){
                            placeRoot(level, placePos.below().north().west(), randomSource, treeConfiguration);
                        }
                        if(placeCheck==height_2n){
                            placeMoss(level, placePos.north().west());
                        }
                }
                if (placeCheck <= height_2s) {
                    placeLog(level, placePos.north().east(), randomSource, treeConfiguration, Direction.Axis.Y);
                        if(placeCheck==0){
                            placeRoot(level, placePos.below().north().east(), randomSource, treeConfiguration);
                        }
                        if(placeCheck==height_2s){
                            placeMoss(level, placePos.north().east());
                        }
                }
                if (placeCheck <= height_2e) {
                    placeLog(level, placePos.south().west(), randomSource, treeConfiguration, Direction.Axis.Y);
                        if(placeCheck==0){
                            placeRoot(level, placePos.below().south().west(), randomSource, treeConfiguration);
                        }
                        if(placeCheck==height_2e){
                            placeMoss(level, placePos.south().west());
                        }
                }
                if (placeCheck <= height_2w) {
                    placeLog(level, placePos.south().east(), randomSource, treeConfiguration, Direction.Axis.Y);
                        if(placeCheck==0){
                            placeRoot(level, placePos.below().south().east(), randomSource, treeConfiguration);
                        }
                        if(placeCheck==height_2w){
                            placeMoss(level, placePos.south().east());
                        }
                }
                if (placeCheck <= height_3n) {
                    placeLog(level, placePos.north().north(), randomSource, treeConfiguration, Direction.Axis.Y);
                        if(placeCheck==0){
                            placeRoot(level, placePos.below().north().north(), randomSource, treeConfiguration);
                        }
                        if(placeCheck==height_3n){
                            placeMoss(level, placePos.north().north());
                        }
                }
                if (placeCheck <= height_3s) {
                    placeLog(level, placePos.south().south(), randomSource, treeConfiguration, Direction.Axis.Y);
                        if(placeCheck==0){
                            placeRoot(level, placePos.below().south().south(), randomSource, treeConfiguration);
                        }
                        if(placeCheck==height_3s){
                            placeMoss(level, placePos.south().south());
                        }
                }
                if (placeCheck <= height_3e) {
                    placeLog(level, placePos.east().east(), randomSource, treeConfiguration, Direction.Axis.Y);
                        if(placeCheck==0){
                            placeRoot(level, placePos.below().east().east(), randomSource, treeConfiguration);
                        }
                        if(placeCheck==height_3e){
                            placeMoss(level, placePos.east().east());
                        }
                }
                if (placeCheck <= height_3w) {
                    placeLog(level, placePos.west().west(), randomSource, treeConfiguration, Direction.Axis.Y);
                        if(placeCheck==0){
                            placeRoot(level, placePos.below().west().west(), randomSource, treeConfiguration);
                        }
                        if(placeCheck==height_3w){
                            placeMoss(level, placePos.west().west());
                        }
                }
                placePos.move(Direction.UP);
                placeCheck = placeCheck + 1;
            }
            else {
                return true;
            }
        }

        return true;
    }

    public void placeTop(LevelAccessor level, BlockPos pos, RandomSource randomSource, RuTreeConfiguration treeConfiguration, boolean hasVines) {
        BlockPos.MutableBlockPos placePos = new BlockPos.MutableBlockPos(pos.getX(),pos.getY(),pos.getZ());
        placeLeavesBlob(level,placePos,randomSource,treeConfiguration, hasVines);
        placeLimbs(level,placePos.below(16),randomSource,treeConfiguration, hasVines);
        placeLimbsUpper(level,placePos.below(8),randomSource,treeConfiguration, hasVines);
    }

    public boolean placeLimbsUpper(LevelAccessor level, BlockPos pos, RandomSource randomSource, RuTreeConfiguration treeConfiguration, boolean hasVines) {
        Random random = new Random();
        int dir = random.nextInt(2);
        int rN = random.nextInt(6);
        BlockPos posN = new BlockPos(pos.getX(), pos.getY()+rN, pos.getZ());
        int rS = random.nextInt(6);
        BlockPos posS = new BlockPos(pos.getX(), pos.getY()+rS, pos.getZ());
        int rE = random.nextInt(6);
        BlockPos posE = new BlockPos(pos.getX(), pos.getY()+rE, pos.getZ());
        int rW = random.nextInt(6);
        BlockPos posW = new BlockPos(pos.getX(), pos.getY()+rW, pos.getZ());
        if(dir==0){
            placeLog(level, posN.north(), randomSource, treeConfiguration, Direction.Axis.Z);
            placeLog(level, posN.north().above().north(), randomSource, treeConfiguration, Direction.Axis.Z);
            placeLog(level, posN.north().above().north().north(), randomSource, treeConfiguration, Direction.Axis.Z);
            placeLog(level, posN.north().above().north().north().north(), randomSource, treeConfiguration, Direction.Axis.Z);
            placeLeavesBlob(level, posN.north().above().north().north().north(), randomSource, treeConfiguration, hasVines);

            placeLog(level, posS.south(), randomSource, treeConfiguration, Direction.Axis.Z);
            placeLog(level, posS.south().above().south(), randomSource, treeConfiguration, Direction.Axis.Z);
            placeLog(level, posS.south().above().south().south(), randomSource, treeConfiguration, Direction.Axis.Z);
            placeLog(level, posS.south().above().south().south().south(), randomSource, treeConfiguration, Direction.Axis.Z);
            placeLeavesBlob(level, posS.south().above().south().south().south(), randomSource, treeConfiguration, hasVines);
        }
        else{
            placeLog(level, posE.east(), randomSource, treeConfiguration, Direction.Axis.X);
            placeLog(level, posE.east().above().east(), randomSource, treeConfiguration, Direction.Axis.X);
            placeLog(level, posE.east().above().east().east(), randomSource, treeConfiguration, Direction.Axis.X);
            placeLog(level, posE.east().above().east().east().east(), randomSource, treeConfiguration, Direction.Axis.X);
            placeLeavesBlob(level, posE.east().above().east().east().east(), randomSource, treeConfiguration, hasVines);

            placeLog(level, posW.west(), randomSource, treeConfiguration, Direction.Axis.X);
            placeLog(level, posW.west().above().west(), randomSource, treeConfiguration, Direction.Axis.X);
            placeLog(level, posW.west().above().west().west(), randomSource, treeConfiguration, Direction.Axis.X);
            placeLog(level, posW.west().above().west().west().west(), randomSource, treeConfiguration, Direction.Axis.X);
            placeLeavesBlob(level, posW.west().above().west().west().west(), randomSource, treeConfiguration, hasVines);
        }

        return true;
    }

    public void placeLimbs(LevelAccessor level, BlockPos pos, RandomSource randomSource, RuTreeConfiguration treeConfiguration, boolean hasVines) {
        Random random = new Random();
        int rN = random.nextInt(8);
        BlockPos posN = new BlockPos(pos.getX(), pos.getY()+rN, pos.getZ());
        int rS = random.nextInt(8);
        BlockPos posS = new BlockPos(pos.getX(), pos.getY()+rS, pos.getZ());
        int rE = random.nextInt(8);
        BlockPos posE = new BlockPos(pos.getX(), pos.getY()+rE, pos.getZ());
        int rW = random.nextInt(8);
        BlockPos posW = new BlockPos(pos.getX(), pos.getY()+rW, pos.getZ());

        placeLog(level, posN.north(), randomSource, treeConfiguration, Direction.Axis.Z);
        placeLog(level, posN.north().above().north(), randomSource, treeConfiguration, Direction.Axis.Z);
        placeLog(level, posN.north().above().north().north(), randomSource, treeConfiguration, Direction.Axis.Z);
        placeLog(level, posN.north().above().north().north().north(), randomSource, treeConfiguration, Direction.Axis.Z);
        placeLeavesBlob(level, posN.north().above().north().north().north(), randomSource, treeConfiguration, hasVines);

        placeLog(level, posS.south(), randomSource, treeConfiguration, Direction.Axis.Z);
        placeLog(level, posS.south().above().south(), randomSource, treeConfiguration, Direction.Axis.Z);
        placeLog(level, posS.south().above().south().south(), randomSource, treeConfiguration, Direction.Axis.Z);
        placeLog(level, posS.south().above().south().south().south(), randomSource, treeConfiguration, Direction.Axis.Z);
        placeLeavesBlob(level, posS.south().above().south().south().south(), randomSource, treeConfiguration, hasVines);

        placeLog(level, posE.east(), randomSource, treeConfiguration, Direction.Axis.X);
        placeLog(level, posE.east().above().east(), randomSource, treeConfiguration, Direction.Axis.X);
        placeLog(level, posE.east().above().east().east(), randomSource, treeConfiguration, Direction.Axis.X);
        placeLog(level, posE.east().above().east().east().east(), randomSource, treeConfiguration, Direction.Axis.X);
        placeLeavesBlob(level, posE.east().above().east().east().east(), randomSource, treeConfiguration, hasVines);

        placeLog(level, posW.west(), randomSource, treeConfiguration, Direction.Axis.X);
        placeLog(level, posW.west().above().west(), randomSource, treeConfiguration, Direction.Axis.X);
        placeLog(level, posW.west().above().west().west(), randomSource, treeConfiguration, Direction.Axis.X);
        placeLog(level, posW.west().above().west().west().west(), randomSource, treeConfiguration, Direction.Axis.X);
        placeLeavesBlob(level, posW.west().above().west().west().west(), randomSource, treeConfiguration, hasVines);

    }

    public boolean placeLog(LevelAccessor level, BlockPos pos, RandomSource randomSource, RuTreeConfiguration treeConfiguration, Direction.Axis axis) {
        Random random = new Random();
        if(level.isOutsideBuildHeight(pos)){
            return true;
        }
        if(level.getBlockState(pos).is(RuBlocks.PEAT_GRASS_BLOCK.get())){
            level.setBlock(pos, RuBlocks.PEAT_DIRT.get().defaultBlockState(), 2);
        }
        else if(level.getBlockState(pos).is(RuBlocks.SILT_GRASS_BLOCK.get())){
            level.setBlock(pos, RuBlocks.SILT_DIRT.get().defaultBlockState(), 2);
        }
        else if(level.getBlockState(pos).is(RuBlocks.ALPHA_GRASS_BLOCK.get())){
            level.setBlock(pos, Blocks.DIRT.defaultBlockState(), 2);
        }
        else if(level.getBlockState(pos).is(Blocks.GRASS_BLOCK)){
            level.setBlock(pos, Blocks.DIRT.defaultBlockState(), 2);
        }
        else if(isReplaceable(level, pos)) {
            level.setBlock(pos, treeConfiguration.trunkProvider.getState(randomSource, pos).setValue(RotatedPillarBlock.AXIS, axis), 2);
        }
        else{
            return true;
        }

        if(level.getBlockState(pos.below()).is(RuBlocks.PEAT_GRASS_BLOCK.get())){
            level.setBlock(pos.below(), RuBlocks.PEAT_DIRT.get().defaultBlockState(), 2);
        }
        else if(level.getBlockState(pos.below()).is(RuBlocks.SILT_GRASS_BLOCK.get())){
            level.setBlock(pos.below(), RuBlocks.SILT_DIRT.get().defaultBlockState(), 2);
        }
        else if(level.getBlockState(pos.below()).is(RuBlocks.ALPHA_GRASS_BLOCK.get())){
            level.setBlock(pos.below(), Blocks.DIRT.defaultBlockState(), 2);
        }
        else if(level.getBlockState(pos.below()).is(Blocks.GRASS_BLOCK)){
            level.setBlock(pos.below(), Blocks.DIRT.defaultBlockState(), 2);
        }
        return true;
    }

    public void placeBranchDecorator(LevelAccessor level, BlockPos pos, RandomSource randomSource, RuTreeConfiguration treeConfiguration) {
        Random random = new Random();
        if(randomSource.nextInt(10)==0){
            int rd = random.nextInt(4);
            if(rd==0){
                placeNorthBranch(level, pos, randomSource, treeConfiguration);
            }
            else if(rd==1){
                placeSouthBranch(level, pos, randomSource, treeConfiguration);
            }
            else if(rd==2){
                placeEastBranch(level, pos, randomSource, treeConfiguration);
            }
            else {
                placeWestBranch(level, pos, randomSource, treeConfiguration);
            }
        }
    }
    public void placeNorthBranch(LevelAccessor level, BlockPos pos, RandomSource randomSource, RuTreeConfiguration treeConfiguration) {
        if(level.getBlockState(pos.north()).canBeReplaced()&&!level.isOutsideBuildHeight(pos.north())){
            level.setBlock(pos.north(), treeConfiguration.branchProvider.getState(randomSource, pos).setValue(BranchBlock.FACING, Direction.NORTH), 2);
        }
        if(level.getBlockState(pos.north().above()).canBeReplaced()&&!level.isOutsideBuildHeight(pos.north().above())){
            level.setBlock(pos.north().above(), treeConfiguration.foliageProvider.getState(randomSource, pos).setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        if(level.getBlockState(pos.north().north()).canBeReplaced()&&!level.isOutsideBuildHeight(pos.north().north())){
            level.setBlock(pos.north().north(), treeConfiguration.foliageProvider.getState(randomSource, pos).setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        if(level.getBlockState(pos.north().east()).canBeReplaced()&&!level.isOutsideBuildHeight(pos.north().east())){
            level.setBlock(pos.north().east(), treeConfiguration.foliageProvider.getState(randomSource, pos).setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        if(level.getBlockState(pos.north().west()).canBeReplaced()&&!level.isOutsideBuildHeight(pos.north().west())){
            level.setBlock(pos.north().west(), treeConfiguration.foliageProvider.getState(randomSource, pos).setValue(LeavesBlock.DISTANCE, 1), 2);
        }

    }
    public void placeSouthBranch(LevelAccessor level, BlockPos pos, RandomSource randomSource, RuTreeConfiguration treeConfiguration) {
        if(level.getBlockState(pos.south()).canBeReplaced()&&!level.isOutsideBuildHeight(pos.south())){
            level.setBlock(pos.south(), treeConfiguration.branchProvider.getState(randomSource, pos).setValue(BranchBlock.FACING, Direction.SOUTH), 2);
        }
        if(level.getBlockState(pos.south().above()).canBeReplaced()&&!level.isOutsideBuildHeight(pos.south().above())){
            level.setBlock(pos.south().above(), treeConfiguration.foliageProvider.getState(randomSource, pos).setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        if(level.getBlockState(pos.south().south()).canBeReplaced()&&!level.isOutsideBuildHeight(pos.south().south())){
            level.setBlock(pos.south().south(), treeConfiguration.foliageProvider.getState(randomSource, pos).setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        if(level.getBlockState(pos.south().east()).canBeReplaced()&&!level.isOutsideBuildHeight(pos.south().east())){
            level.setBlock(pos.south().east(), treeConfiguration.foliageProvider.getState(randomSource, pos).setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        if(level.getBlockState(pos.south().west()).canBeReplaced()&&!level.isOutsideBuildHeight(pos.south().west())){
            level.setBlock(pos.south().west(), treeConfiguration.foliageProvider.getState(randomSource, pos).setValue(LeavesBlock.DISTANCE, 1), 2);
        }

    }
    public void placeEastBranch(LevelAccessor level, BlockPos pos, RandomSource randomSource, RuTreeConfiguration treeConfiguration) {
        if(level.getBlockState(pos.east()).canBeReplaced()&&!level.isOutsideBuildHeight(pos.east())){
            level.setBlock(pos.east(), treeConfiguration.branchProvider.getState(randomSource, pos).setValue(BranchBlock.FACING, Direction.EAST), 2);
        }
        if(level.getBlockState(pos.east().above()).canBeReplaced()&&!level.isOutsideBuildHeight(pos.east().above())){
            level.setBlock(pos.east().above(), treeConfiguration.foliageProvider.getState(randomSource, pos).setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        if(level.getBlockState(pos.east().east()).canBeReplaced()&&!level.isOutsideBuildHeight(pos.east().east())){
            level.setBlock(pos.east().east(), treeConfiguration.foliageProvider.getState(randomSource, pos).setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        if(level.getBlockState(pos.east().south()).canBeReplaced()&&!level.isOutsideBuildHeight(pos.east().south())){
            level.setBlock(pos.east().south(), treeConfiguration.foliageProvider.getState(randomSource, pos).setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        if(level.getBlockState(pos.east().north()).canBeReplaced()&&!level.isOutsideBuildHeight(pos.east().north())){
            level.setBlock(pos.east().north(), treeConfiguration.foliageProvider.getState(randomSource, pos).setValue(LeavesBlock.DISTANCE, 1), 2);
        }

    }
    public void placeWestBranch(LevelAccessor level, BlockPos pos, RandomSource randomSource, RuTreeConfiguration treeConfiguration) {
        if(level.getBlockState(pos.west()).canBeReplaced()&&!level.isOutsideBuildHeight(pos.west())){
            level.setBlock(pos.west(), treeConfiguration.branchProvider.getState(randomSource, pos).setValue(BranchBlock.FACING, Direction.WEST), 2);
        }
        if(level.getBlockState(pos.west().above()).canBeReplaced()&&!level.isOutsideBuildHeight(pos.west().above())){
            level.setBlock(pos.west().above(), treeConfiguration.foliageProvider.getState(randomSource, pos).setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        if(level.getBlockState(pos.west().west()).canBeReplaced()&&!level.isOutsideBuildHeight(pos.west().west())){
            level.setBlock(pos.west().west(), treeConfiguration.foliageProvider.getState(randomSource, pos).setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        if(level.getBlockState(pos.west().south()).canBeReplaced()&&!level.isOutsideBuildHeight(pos.west().south())){
            level.setBlock(pos.west().south(), treeConfiguration.foliageProvider.getState(randomSource, pos).setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        if(level.getBlockState(pos.west().north()).canBeReplaced()&&!level.isOutsideBuildHeight(pos.west().north())){
            level.setBlock(pos.west().north(), treeConfiguration.foliageProvider.getState(randomSource, pos).setValue(LeavesBlock.DISTANCE, 1), 2);
        }

    }

    public void placeRoot(LevelAccessor level, BlockPos pos, RandomSource randomSource, RuTreeConfiguration treeConfiguration) {
        Random random = new Random();
        int rd = random.nextInt(2)+4;
        int i = 0;
        BlockPos.MutableBlockPos placePos = pos.mutable();
        while(i<=rd){
            if(level.getBlockState(placePos).canBeReplaced()&&level.getBlockState(placePos.above()).is(BlockTags.DIRT)){
                level.setBlock(placePos, Blocks.HANGING_ROOTS.defaultBlockState(), 2);
                break;
            }
            placeLog(level, placePos, randomSource, treeConfiguration, Direction.Axis.Y);
            placePos.move(Direction.DOWN);
            i++;
        }
    }

    public boolean placeMoss(LevelAccessor level, BlockPos pos) {
        Random random = new Random();
        if(level.getBlockState(pos.above()).isAir()){
            if(random.nextInt(2)==0){
                level.setBlock(pos.above(), Blocks.MOSS_CARPET.defaultBlockState(), 2);
            }
            if(random.nextInt(7)==0){
                if(random.nextInt(2)==0){
                    level.setBlock(pos.above(), RuBlocks.GREEN_BIOSHROOM.get().defaultBlockState(), 2);
                }
                level.setBlock(pos, Blocks.MOSS_BLOCK.defaultBlockState(), 2);
            }
        }

        return true;
    }

    private static void placeVine(LevelAccessor level, BlockPos pos) {
        Random random = new Random();
        int size = random.nextInt(6);
        BlockPos place = pos.below();
        for(int i = 0; i<=size; i++){
            if(level.getBlockState(place).isAir()){
                if(i==size){
                    level.setBlock(place, RuBlocks.SPANISH_MOSS.get().defaultBlockState().setValue(SpanishMossBlock.AGE, 25), 2);
                }
                else {
                    level.setBlock(place, RuBlocks.SPANISH_MOSS_PLANT.get().defaultBlockState(), 2);
                }
                place = place.below();
            }
            else{
                if(i!=0){
                    level.setBlock(place.above(), RuBlocks.SPANISH_MOSS.get().defaultBlockState().setValue(SpanishMossBlock.AGE, 25), 2);
                }
                break;
            }
        }
    }

    public void placeLeavesBlob(LevelAccessor level, BlockPos pos, RandomSource randomSource, RuTreeConfiguration treeConfiguration, boolean hasVines) {
        placeLeavesBlock(level, pos, randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.north(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.north().east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.north().west(), randomSource, treeConfiguration);

        placeLeavesBlock(level, pos.north(2), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.north(2).east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.north(2).west(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.north(2).east(2), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.north(2).west(2), randomSource, treeConfiguration);

        placeLeavesBlock(level, pos.north(3), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.north(3).east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.north(3).west(), randomSource, treeConfiguration);

        if(hasVines){
            if(randomSource.nextInt(2)==0) {
                placeVine(level, pos.north(3));
            }
            if(randomSource.nextInt(2)==0) {
                placeVine(level, pos.north(3).east());
            }
            if(randomSource.nextInt(2)==0) {
                placeVine(level, pos.north(3).west());
            }
        }

        placeLeavesBlock(level, pos.south(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.south().east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.south().west(), randomSource, treeConfiguration);

        placeLeavesBlock(level, pos.south(2), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.south(2).east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.south(2).west(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.south(2).east(2), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.south(2).west(2), randomSource, treeConfiguration);

        placeLeavesBlock(level, pos.south(3), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.south(3).east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.south(3).west(), randomSource, treeConfiguration);

        if(hasVines){
            if(randomSource.nextInt(2)==0) {
                placeVine(level, pos.south(3));
            }
            if(randomSource.nextInt(2)==0) {
                placeVine(level, pos.south(3).east());
            }
            if(randomSource.nextInt(2)==0) {
                placeVine(level, pos.south(3).west());
            }
        }

        placeLeavesBlock(level, pos.east(), randomSource, treeConfiguration);

        placeLeavesBlock(level, pos.east(2), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.east(2).north(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.east(2).south(), randomSource, treeConfiguration);

        placeLeavesBlock(level, pos.east(3), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.east(3).north(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.east(3).south(), randomSource, treeConfiguration);

        if(hasVines){
            if(randomSource.nextInt(2)==0) {
                placeVine(level, pos.east(3));
            }
            if(randomSource.nextInt(2)==0) {
                placeVine(level, pos.east(3).north());
            }
            if(randomSource.nextInt(2)==0) {
                placeVine(level, pos.east(3).south());
            }
        }

        placeLeavesBlock(level, pos.west(), randomSource, treeConfiguration);

        placeLeavesBlock(level, pos.west(2), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.west(2).north(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.west(2).south(), randomSource, treeConfiguration);

        placeLeavesBlock(level, pos.west(3), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.west(3).north(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.west(3).south(), randomSource, treeConfiguration);

        if(hasVines){
            if(randomSource.nextInt(2)==0) {
                placeVine(level, pos.west(3));
            }
            if(randomSource.nextInt(2)==0) {
                placeVine(level, pos.west(3).north());
            }
            if(randomSource.nextInt(2)==0) {
                placeVine(level, pos.west(3).south());
            }
        }


        placeLeavesBlock(level, pos.above(), randomSource, treeConfiguration);

        placeLeavesBlock(level, pos.above().north(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.above().north(2), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.above().north().east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.above().north().west(), randomSource, treeConfiguration);

        placeLeavesBlock(level, pos.above().south(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.above().south().east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.above().south().west(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.above().south(2), randomSource, treeConfiguration);

        placeLeavesBlock(level, pos.above().east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.above().east(2), randomSource, treeConfiguration);

        placeLeavesBlock(level, pos.above().west(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.above().west(2), randomSource, treeConfiguration);

    }

    public boolean placeLeavesBlock(LevelAccessor level, BlockPos pos, RandomSource randomSource, RuTreeConfiguration treeConfiguration) {
        Random random = new Random();
        if(level.isOutsideBuildHeight(pos)){
            return true;
        }
        if(level.getBlockState(pos).canBeReplaced()) {
            level.setBlock(pos, treeConfiguration.foliageProvider.getState(randomSource, pos).setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        return true;
    }

    public boolean checkReplaceable(LevelAccessor level, BlockPos pos) {
        if(level.isOutsideBuildHeight(pos)){
            return false;
        }
        if(!isReplaceable(level, pos)) {
            return false;
        }
        return true;
    }
    
    public static boolean isReplaceableDirtBlock(BlockState state) {
        return state.is(RuTags.TREE_GRASS_REPLACEABLES);
    }

    public static boolean isReplaceableDirt(LevelSimulatedReader reader, BlockPos pos) {
        return reader.isStateAtPosition(pos, GiantCypressTreeFeature::isReplaceableDirtBlock);
    }

    public static boolean isReplaceableBlock(BlockState state) {
        return state.is(RuTags.REPLACEABLE_BLOCKS);
    }

    public static boolean isReplaceable(LevelSimulatedReader reader, BlockPos pos) {
        return reader.isStateAtPosition(pos, GiantCypressTreeFeature::isReplaceableBlock);
    }
}